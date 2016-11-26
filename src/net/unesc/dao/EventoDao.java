package net.unesc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.unesc.banco.Conexao;
import net.unesc.banco.Funcoes;
import net.unesc.entidades.Evento;
import net.unesc.entidades.FormaAlerta;
import net.unesc.entidades.Regra;
import net.unesc.entidades.TipoEvento;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.exceptions.DataException;
import net.unesc.exceptions.FormaAlertaException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.*;

public class EventoDao extends DaoPadrao {
    
    public void atualiza(Evento evento) throws BancoException, FormaAlertaException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            String sql = "update evento set ie_situacao = ?, dt_ultima_execucao = ? where nr_sequencia = ?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getSituacao());
            ps.setTimestamp(2, new Timestamp(evento.getUltimaOcorrencia().getTime()));    
            ps.setInt(3, evento.getCodigo());
            ps.execute();
            conn.commit();
            LogSistema.inserir(TipoLog.INCLUSAO, "Atualizou o evento: "+evento.getCodigo());
        } catch(SQLException e) {  
            erro(conn, "Erro ao atualizar evento", e);
        } finally {
            finaliza(conn, ps);
        }
    }
    
    public void inserir(Evento evento) throws BancoException, FormaAlertaException {
        if (evento.getFormasAlerta().size() < 1) { 
            throw new FormaAlertaException("Selecione ao menos uma forma de alerta");
        }
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            Integer proxSequencia = Funcoes.obterSequencia("evento");   
              
            String sql = "insert into evento (nr_sequencia, nm_usuario, dt_inclusao, "
                    + "ds_evento, ie_email, ie_sms, ie_popup, ie_notificacao, "
                    + "ds_email, nr_ddd_celular, nr_celular, ie_tipo_evento, cor, ie_situacao, NR_SEQ_REGRA)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, proxSequencia);
            ps.setString(2, evento.getUsuario().getLogin());
            ps.setString(3, DiaHora.obterDiaHora("yyyy-MM-dd HH:mm:ss"));
            ps.setString(4, evento.getDescricao());
            ps.setString(5, evento.getEnviar(FormaAlerta.EMAIL));
            ps.setString(6, evento.getEnviar(FormaAlerta.SMS));
            ps.setString(7, evento.getEnviar(FormaAlerta.POPUP));
            ps.setString(8, evento.getEnviar(FormaAlerta.NOTIFICACAO));
            ps.setString(9, evento.getEmail());
            ps.setString(10, evento.getDdd());
            ps.setString(11, evento.getCelular());
            ps.setString(12, evento.getTipoEvento().toString());
            ps.setString(13, evento.getCor());
            ps.setString(14, evento.getSituacao());    
            ps.setInt(15, evento.getRegra().getCodigo());
            System.out.println(ps);
            ps.execute();
            conn.commit();
            LogSistema.inserir(TipoLog.INCLUSAO, "Gravou um novo Cadastro de eventos");
        } catch(SQLException e) {  
            erro(conn, "Erro ao cadastar evento", e);
        } finally {
            finaliza(conn, ps);
        }
    }
    
    public List<Evento> getAtivosERegra() throws BancoException {
        List<Evento> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = 
                " select distinct nr_sequencia, nm_usuario, dt_inclusao, " +
                " ds_evento, ie_email, ie_sms, ie_popup, ie_notificacao, " +
                " ds_email, nr_ddd_celular, nr_celular, ie_tipo_evento, cor, ie_situacao, dt_ultima_execucao, NR_SEQ_REGRA " +
                " dt_inclusao, " +
                " ds_regra," +
                " dt_inicio_vigencia," +
                " dt_fim_vigencia," +
                " ie_situacao," +
                " ie_tipo_horario," +
                " qt_hh," +
                " qt_mm," +
                " qt_ss," +
                " qt_ml," +
                " dia_dom," +
                " dia_seg," +
                " dia_ter," +
                " dia_qua," +
                " dia_qui," +
                " dia_sex," +
                " dia_sab" +
                " from evento, regra_evento " +
                " where evento.ie_situacao = 'A'" +
                " and regra_evento.ie_situacao = 'A'"+    
                " and regra_evento.nr_sequencia = evento.nr_seq_regra ";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Evento e = new Evento();
                e.fromResultSet(rs);
                
                Regra p = new Regra();
                p.fromResultSet(rs);
                e.setRegra(p);  
               // System.out.println(e.toString());
                lista.add(e);
            }
        } catch(SQLException|CampoObrigatorioException e) {
            erro(conn, "Erro ao buscar os eventos", e);
        } finally {
            finaliza(conn, ps);
        }
        return lista;
    }
}

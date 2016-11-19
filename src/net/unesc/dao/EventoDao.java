package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.unesc.banco.Conexao;
import net.unesc.banco.Funcoes;
import net.unesc.entidades.Evento;
import net.unesc.entidades.FormaAlerta;
import net.unesc.entidades.Regra;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.exceptions.DataException;
import net.unesc.exceptions.FormaAlertaException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.*;

public class EventoDao extends DaoPadrao {
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
                    + "ds_email, nr_ddd_celular, nr_celular, ie_tipo_evento, cor, ie_situacao)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
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
    
    public List<Evento> getAtivos() throws BancoException {
        List<Evento> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = 
                " select * " +
                " from evento " +
                " where evento.ie_situacao = 'A'";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Evento p = new Evento();
                                
                lista.add(p);
            }
        } catch(SQLException e) {
            erro(conn, "Erro ao buscar os eventos", e);
        } finally {
            finaliza(conn, ps);
        }
        return lista;
    }
}

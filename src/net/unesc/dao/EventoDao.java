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
import net.unesc.exceptions.FormatoDataException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.*;

public class EventoDao extends DaoPadrao {
    
    private RegraEventoDao regraEventoDao = new RegraEventoDao();
    private ArrayList<Regra> regras;
    
    public void atualiza(Evento evento) throws BancoException, FormaAlertaException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
            if (evento.getUltimaOcorrencia() != null)
            {
                timestamp =  new Timestamp(evento.getUltimaOcorrencia().getTime());
            }
            conn = Conexao.getConnection();
            String sql = "update evento set ie_situacao = ?, dt_ultima_execucao = ? where nr_sequencia = ?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getSituacao());
            ps.setTimestamp(2, timestamp);    
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
    
    public void excluirEvento(Evento evento) throws BancoException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from evento where nr_sequencia = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, evento.getCodigo());
            ps.execute();
            conn.commit();
            LogSistema.inserir(TipoLog.EXCLUSAO, "Excluiu um Cadastro de evento");
        } catch(SQLException e) {
            erro(conn, "Erro ao excluir evento", e);
        } finally {
            finaliza(conn, ps);
        }
    }
    
    public ArrayList<Evento> getAll() throws BancoException, CampoObrigatorioException, DataException,FormatoDataException {
        ArrayList<Evento> lista = new ArrayList<Evento>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = 
                " select * "+
                " from evento";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Evento p = new Evento();
                p.setCodigo(rs.getInt(1));
                p.setDescricao(rs.getString(4));
                
                if(rs.getString(5).equals("S")){
                    p.addFormaAlerta(FormaAlerta.EMAIL);
                }
                
                if(rs.getString(6).equals("S")){
                    p.addFormaAlerta(FormaAlerta.SMS);
                }
                
                if(rs.getString(7).equals("S")){
                    p.addFormaAlerta(FormaAlerta.POPUP);
                }
                
                if(rs.getString(8).equals("S")){
                    p.addFormaAlerta(FormaAlerta.NOTIFICACAO);
                }
                
                p.setEmail(rs.getString(9));
                p.setDdd(rs.getString(10));
                p.setCelular(rs.getString(11));
                
                if(rs.getString(12).toUpperCase().equals("GASOLINA")){    
                    p.setTipoEvento((TipoEvento.GASOLINA));
                }else
                {
                    p.setTipoEvento((TipoEvento.ALMOCO));
                }
                
                regras = regraEventoDao.getRegras(rs.getInt(16));

                p.setRegra(regras.get(0));
                p.setCor(rs.getString(13));
                p.setSituacao(rs.getString(14));
                
                lista.add(p);
            }
        } catch(SQLException e) {
            erro(conn, "Erro ao buscar os eventos", e);
        } finally {
            finaliza(conn, ps);
        }
        return lista;
    }
 
    public ArrayList<Evento> getEventos(String descricao)throws BancoException, CampoObrigatorioException, DataException, FormatoDataException{
        ArrayList<Evento> lista = new ArrayList<Evento>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = 
                " select * "+
                " from evento "+
                " where upper(ds_evento) like ? or ? =''";     
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+descricao.toUpperCase().trim()+"%");
            ps.setString(2, "%"+descricao.toUpperCase().trim()+"%");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Evento p = new Evento();
                p.setCodigo(rs.getInt(1));
                p.setDescricao(rs.getString(4));
                
                if(rs.getString(5).equals("S")){
                    p.addFormaAlerta(FormaAlerta.EMAIL);
                }
                
                if(rs.getString(6).equals("S")){
                    p.addFormaAlerta(FormaAlerta.SMS);
                }
                
                if(rs.getString(7).equals("S")){
                    p.addFormaAlerta(FormaAlerta.POPUP);
                }
                
                if(rs.getString(8).equals("S")){
                    p.addFormaAlerta(FormaAlerta.NOTIFICACAO);
                }
                
                p.setEmail(rs.getString(9));
                p.setDdd(rs.getString(10));
                p.setCelular(rs.getString(11));
                
                if(rs.getString(12).toUpperCase().equals("GASOLINA")){    
                    p.setTipoEvento((TipoEvento.GASOLINA));
                }else
                {
                    p.setTipoEvento((TipoEvento.ALMOCO));
                }
                
                regras = regraEventoDao.getRegras(rs.getInt(16));

                p.setRegra(regras.get(0));
                p.setCor(rs.getString(13));
                p.setSituacao(rs.getString(14));
                
                lista.add(p);
            }
        } catch(SQLException e) {
            erro(conn, "Erro ao buscar as regras", e);
        } finally {
            finaliza(conn, ps);
        }
        return lista;
    }
    
    public void alteraEvento(Evento evento) throws BancoException{
        Connection conn = null;
        PreparedStatement ps = null;
 
        try {
            conn = Conexao.getConnection();
            String sql = "update evento set "+
                    " ds_evento = ? ,"+
                    " ie_email = ? ,"+
                    " ie_sms = ? ,"+
                    " ie_popup = ? ,"+
                    " ie_notificacao = ? ,"+
                    " ds_email = ? ,"+
                    " nr_ddd_celular = ? ,"+
                    " nr_celular = ? ,"+
                    " ie_tipo_evento = ? ,"+
                    " cor = ? ,"+
                    " ie_situacao = ? ,"+
                    " NR_SEQ_REGRA = ? "+
                    " where nr_sequencia = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getDescricao());
            ps.setString(2, evento.getEnviar(FormaAlerta.EMAIL));
            ps.setString(3, evento.getEnviar(FormaAlerta.SMS));
            ps.setString(4, evento.getEnviar(FormaAlerta.POPUP));
            ps.setString(5, evento.getEnviar(FormaAlerta.NOTIFICACAO));
            ps.setString(6, evento.getEmail());
            ps.setString(7, evento.getDdd());
            ps.setString(8, evento.getCelular());
            ps.setString(9, evento.getTipoEvento().toString());
            ps.setString(10, evento.getCor());
            ps.setString(11, evento.getSituacao());    
            ps.setInt(12, evento.getRegra().getCodigo());
            ps.setInt(13, evento.getCodigo());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            erro(conn, "Erro ao alterar o evento", e);
        } finally {
            finaliza(conn, ps);
        }
    }
}

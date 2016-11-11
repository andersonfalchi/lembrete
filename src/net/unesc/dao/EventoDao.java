package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.unesc.banco.Conexao;
import net.unesc.banco.Funcoes;
import net.unesc.entidades.Evento;
import net.unesc.entidades.FormaAlerta;
import net.unesc.exceptions.BancoException;
import net.unesc.utilidades.*;

public class EventoDao {
    public static void inserir(Evento evento) throws BancoException {
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
            ps.setString(3, DiaHora.ObterDiaHora("yyyy-MM-dd HH:mm:ss"));
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
        } catch(SQLException e) {            
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro ao cadastar Evento",JOptionPane.ERROR_MESSAGE);
                }
            }
            throw new BancoException("Erro ao cadastar Evento"); 

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

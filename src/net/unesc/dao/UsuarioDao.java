package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.unesc.banco.Conexao;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;

public class UsuarioDao {
    
    public static void insert(Usuario usuario) throws BancoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into usuario (nm_usuario, ds_login, ds_senha, ie_situacao)"
                    + "values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getSituacao());
            ps.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!","Cadastro de usuário",JOptionPane.INFORMATION_MESSAGE);
            
        } catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(),"Cadastro de usuário",JOptionPane.ERROR_MESSAGE);
                    
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
    
}

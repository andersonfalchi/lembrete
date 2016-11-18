package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.unesc.banco.Conexao;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;

public class UsuarioDao extends DaoPadrao {
    
    public void inserir(Usuario usuario) throws BancoException {
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
            LogSistema.inserir(TipoLog.INCLUSAO, "Gravou um novo Cadastro de usuário");
        }catch(SQLException e){
            erro(conn, "Erro ao obter usuario", e);
            
        } finally {
            finaliza(conn, ps);
        }
    }
    
}

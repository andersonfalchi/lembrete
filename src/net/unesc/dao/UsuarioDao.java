package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.unesc.banco.Conexao;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.exceptions.DataException;
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
    
    
    public ArrayList<Usuario> getAll() throws BancoException {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = 
                " select * "+
                " from usuario";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Usuario p = new Usuario();
                p.setNome(rs.getString(1));
                p.setLogin(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setSituacao(rs.getString(4));
                lista.add(p);
            }
        } catch(SQLException e) {
            erro(conn, "Erro ao buscar os usuarios", e);
        } finally {
            finaliza(conn, ps);
        }
        return lista;
    }
    
    public ArrayList<Usuario> getUsuarios(String nome, String login)throws BancoException{
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = 
                " select * "+
                " from usuario"+
                " where 1=1 "+
                " and (upper(ds_login) = ? or ? ='')"+    
                " and (upper(nm_usuario)= ? or ? ='')";        

            ps = conn.prepareStatement(sql);
            ps.setString(1, login.trim().toUpperCase());
            ps.setString(2, login.trim().toUpperCase());
            ps.setString(3, nome.trim().toUpperCase());
            ps.setString(4, nome.trim().toUpperCase());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Usuario p = new Usuario();
                p.setNome(rs.getString(1));
                p.setLogin(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setSituacao(rs.getString(4));
                lista.add(p);
            }
        } catch(SQLException e) {
            erro(conn, "Erro ao buscar os usuarios", e);
        } finally {
            finaliza(conn, ps);
        }
        return lista;
    }
    
    public void excluirUsuario(String login) throws BancoException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from usuario where upper(ds_login) = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, login.trim());
            ps.execute();
            conn.commit();
            LogSistema.inserir(TipoLog.EXCLUSAO, "Excluiu um Cadastro de usuário");
        } catch(SQLException e) {
            erro(conn, "Erro ao excluir usuario", e);
        } finally {
            finaliza(conn, ps);
        }
    }
 
    public void alteraUsuario(Usuario usuario) throws BancoException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update usuario set "+
                    " nm_usuario = ?, "+
                    " ds_senha = ?, "+
                    " ie_situacao = ? "+
                    " where ds_login = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getSituacao());
            ps.setString(4, usuario.getLogin());
            ps.execute();

            conn.commit();
        } catch(SQLException e) {
            erro(conn, "Erro ao alterar usuario", e);
        } finally {
            finaliza(conn, ps);
        }
    }
}

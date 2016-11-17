package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.unesc.banco.Conexao;
import net.unesc.exceptions.BancoException;
import net.unesc.entidades.Usuario;

public class SessaoDao extends DaoPadrao {
    
    public boolean logar(Usuario usuario) throws BancoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            
            String sql="select count(*) from usuario where ie_situacao = 'A'"+
                    " and upper(ds_login)='"+usuario.getLogin().toUpperCase().trim()+"'"+
                    " and upper(ds_senha) = '"+usuario.getSenha().toUpperCase().trim()+"'";
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(sql);
                        
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(sql);
            if(rs.getInt(1) == 1){
                return true;
            }
        }catch(SQLException e){
            erro(conn, "Erro ao obter usuario", e);
            
        } finally {
            finaliza(conn, ps);
        }
        return false;
    } 
}

package net.unesc.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcoes {
    
    public static Integer ObterSequencia(String tabela){
        Integer sequencia=1;
        
        try{
            Connection conn = null;
            PreparedStatement ps = null;
            
            conn = Conexao.getConnection();
            ps = conn.prepareStatement("select max(nr_sequencia)+1 from "+tabela);
            ResultSet rs = ps.executeQuery();
            rs.next();

            if(rs.getInt(1) >1){
                sequencia = rs.getInt(1);
            }

            
        }catch(SQLException e){
            throw new SQLException("Erro ao obter sequencia");      
            
        }finally{
            return sequencia;
        }
    }    
    
}

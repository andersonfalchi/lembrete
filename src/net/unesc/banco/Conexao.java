package net.unesc.banco;

import java.sql.*;
import net.unesc.exceptions.BancoException;

public class Conexao {
    
    public static Connection getConnection()throws BancoException {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            //conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bancodb", "sa", "");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/lembretedb", "sa", "");
        } catch (SQLException e) {
            System.out.println("Problemas ao conectar no banco de dados");
        } catch (ClassNotFoundException e) {
            throw new BancoException("O driver não foi configurado corretamente");
        }

        return conn;
    }
    
    
}

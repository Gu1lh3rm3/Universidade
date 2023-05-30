package fei_secretaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "fei";
    private Connection conn;
    
    public Connection conectar() {
        try{
            // Configurações de conexão com o banco de dados
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado com Sucesso");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar: "+e.getMessage());
            return null;
        }
        
    }
    
    public void desconectar() {
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desconectar: "+ e);
        }
    }

    PreparedStatement PrepareStatemant(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

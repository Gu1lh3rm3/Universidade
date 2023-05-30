package fei_aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
    Connection connection = null;
    
    public Connection conectar() {
        try{
            // Configurações de conexão com o banco de dados
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            //String username = "postgres";
            //String password = "fei";
            connection = DriverManager.getConnection(url,"postgres","fei");
            System.out.println("Conectado com Sucesso");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar: "+e.getMessage());
            return null;
        }
    }
    
    public void desconectar() {
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desconectar: "+ e);
        }
    }

    PreparedStatement PrepareStatemant(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

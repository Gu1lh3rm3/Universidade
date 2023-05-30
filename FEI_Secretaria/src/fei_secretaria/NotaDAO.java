package fei_secretaria;

import java.sql.SQLException ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;

//Tarefas: desenvolver os metodos
//
// CADASTRO:    inserir(Disciplina disciplina, String ra, Nota nota);
// ATUALIZAR:   atualizarNota(String codigo, String ra, Nota nota, int index);
// BUSCAR:      buscarNota(String ra);
// REMOVER:      buscarNota(String ra);

public class NotaDAO extends Conexao{
    private Connection conn ;
    private PreparedStatement pstmt ;
    private ResultSet rs ;
    
    public NotaDAO (){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
    }

    public void inserir(String codigo, int ra) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("INSERT INTO NOTAS (CODIGO, RA) VALUES (?, ?)");
            // Setando o valor aos parâmetros
            pstmt.setString(1, codigo);
            pstmt.setInt(2, ra);
            // Executando o comando sql do objeto preparedStatement​
            pstmt.execute();
            System.out.println("Inserido com Sucesso");
            conexao.desconectar(); // Fechando a conexão com o banco​
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
        }
    }

    public void remover(String codigo, int ra) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            String remover = "DELETE FROM DEPT WHERE CODIGO = ? AND RA = ?";
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement(remover);
            // Setando o valor ao parâmetro​
            pstmt.setString(1, codigo);
            pstmt.setDouble(2, ra);
            // Executando o comando sql do objeto preparedStatement​
            pstmt.execute();
            System.out.println("Removido com Sucesso");
            conexao.desconectar(); // Fechando a conexão com o banco​
        } catch (SQLException e) {
            conexao.desconectar(); // Fechando a conexão com o banco​
        }
    }

    public void alterarNota(String codigo, int ra, double nota, int index) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        String query;
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            if(index == 1)
                query = "UPDATE NOTAS SET NOTA1 = ? WHERE CODIGO = ? AND RA = ?";
            else
                query = "UPDATE NOTAS SET NOTA2 = ? WHERE CODIGO = ? AND RA = ?";
            pstmt = conn.prepareStatement(query);
            // Setando o valor ao parâmetro​
            pstmt.setDouble(1, nota);
            pstmt.setString(2, codigo);
            pstmt.setInt(3, ra);
            // Executando o comando sql do objeto preparedStatement​
            pstmt.execute();
            System.out.println("Alterado com Sucesso");
            // Fechando a conexão com o banco​
            conexao.desconectar();
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
        }
    }

    public void alterarMedia(String codigo, int ra, double media) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            String alterar = "UPDATE NOTAS SET MEDIA = ? WHERE CODIGO = ? AND RA = ?";
            pstmt = conn.prepareStatement(alterar);
            // Setando o valor ao parâmetro​
            pstmt.setDouble(1, media);
            pstmt.setString(2, codigo);
            pstmt.setInt(3, ra);
            // Executando o comando sql do objeto preparedStatement​
            pstmt.execute();
            System.out.println("Alterado com Sucesso");
            // Fechando a conexão com o banco​
            conexao.desconectar();
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
        }
    }

}
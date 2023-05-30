package fei_secretaria;

import java.sql.SQLException ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import javax.swing.JOptionPane;

//Tarefas: desenvolver os metodos
//
// CADASTRO:    inserir(Aluno aluno);
// REMOÇÃO:     remover(String ra);
// BUSCAR:      buscar();
// BUSCAR:      buscarNome(String nome);
// BUSCAR:      buscarRA(int ra);

public class AlunoDAO extends Conexao{
    private Connection conn ;
    private PreparedStatement pstmt ;
    private ResultSet rs ;

    public AlunoDAO (){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
    }
    
    public void inserir(Aluno aluno) {
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        String inserir = "INSERT INTO ALUNOS (RA, NOME, SENHA, LOGIN) VALUES (?, ?, ?, ?)";
        try {    
            pstmt = conn.prepareStatement(inserir);
            pstmt.setInt(1, aluno.getRA());
            pstmt.setString(2, aluno.getNome());
            pstmt.setString(3, aluno.getSenha());
            pstmt.setString(4, aluno.getLogin());    
            if (pstmt.execute()){
                JOptionPane.showMessageDialog ( null , " Aluno inserido com sucesso ", " Info ", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog ( null , " Não foi possível inserir o aluno no banco de dados ", " Info ", JOptionPane.INFORMATION_MESSAGE);
            }
            conexao.desconectar();
        } catch (SQLException e) {
            conexao.desconectar();
            System.err.println("Falha em Inserir Aluno no Bando de Dados" + e.getMessage());
        }
    }

    public void remover(String ra){
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        String remover = "DELETE FROM ALUNOS WHERE RA = ?";
        try {
            pstmt = conn.prepareStatement(remover);
            pstmt.setString(1, ra);
            if (pstmt.execute()){
                JOptionPane.showMessageDialog ( null , " Disciplina removida com sucesso ", " Info ", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog ( null , " Não foi possível remover a disciplina ", " Info ", JOptionPane.INFORMATION_MESSAGE);
            }
            conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog ( null , " Erro de comunicação com o banco de dados ", " Alerta ", JOptionPane.ERROR_MESSAGE);
            conexao.desconectar();
        }
    }

    public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM ALUNOS ORDER BY NOME");
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }

    public ResultSet buscarNome(String nome) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM ALUNOS WHERE NOME = ? ORDER BY NOME");
            pstmt.setString(1, nome);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
}


package fei_secretaria;

import java.sql.SQLException ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;

import javax.swing.JOptionPane;

//Tarefas: desenvolver os metodos
//
// CADASTRO:    inserir(Disciplina disciplina);
// REMOÇÃO:     remover(String codigo);
// BUSCAR:      buscar(String codigo);
// BUSCAR:      buscarNome(String nome);

public class DisciplinaDAO {
    private Connection conn;
    private PreparedStatement pstmt ;
    private ResultSet rs ;
    
    public DisciplinaDAO (){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
    }
    
    public void inserir(Disciplina disciplina) {
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        String inserir = "INSERT INTO DISCIPLINAS (CODIGO, NOME, SEMESTRE, PROFESSOR) VALUES (?, ?, ?, ?)";

        try {
            pstmt = this.conn.prepareStatement(inserir);
            pstmt.setString(1, disciplina.getCodigo());
            pstmt.setString(2, disciplina.getNome());
            pstmt.setInt(3, disciplina.getSemestre());
            pstmt.setString(4, disciplina.getProfessor());
            pstmt.execute();
            System.out.println("Disciplina inserida com Sucesso");
            conexao.desconectar();
        } catch (SQLException e) {
            conexao.desconectar();
            throw new RuntimeException("uncaught", e);
        }
    }

    public void remover(String codigo){
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            String remover = "DELETE FROM DISCIPLINAS WHERE CODIGO = ?";
            pstmt = conn.prepareStatement(remover);
            pstmt.setString(1, codigo);
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
            pstmt = conn.prepareStatement("SELECT * FROM DISCIPLINAS ORDER BY NOME");
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
            pstmt = conn.prepareStatement("SELECT * FROM DISCIPLINAS WHERE NOME = ? ORDER BY NOME");
            //pstmt = conn.prepareStatement("SELECT * FROM DISCIPLINAS WHERE NOME LIKE ? ORDER BY NOME");
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

    public ResultSet buscarCodigo(String codigo) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM DISCIPLINAS WHERE CODIGO = ? ORDER BY NOME");
            //pstmt = conn.prepareStatement("SELECT * FROM DISCIPLINAS WHERE NOME LIKE ? ORDER BY NOME");
            pstmt.setString(1, codigo);
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

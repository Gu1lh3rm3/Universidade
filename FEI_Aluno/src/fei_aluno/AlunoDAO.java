package fei_aluno;

import java.sql.SQLException ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;

//Tarefas: desenvolver os metodos
//
// ALTERAR:     alteraSenha(Aluno aluno);       //botao "esqueci a senha"
// BUSCAR:      buscaHistorico(String ra);      //cursou = true
// BUSCAR:      buscaDisciplinas(String ra);    //cursou = false

public class AlunoDAO{
    private Connection conn;
    private PreparedStatement pstmt ;
    private ResultSet rs ;
    
    public AlunoDAO (){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar(); //REVISAR ESTA LINHA
    }
    
    public boolean verificaLogin(Aluno aluno) {
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        
        String sql = "select * from alunos where login = ? and senha = ?";

        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, aluno.getLogin());
            pstmt.setString(2, aluno.getSenha());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public ResultSet buscaHistorico(Aluno aluno) {
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            pstmt = conn.prepareStatement("select * from NOTAS where RA = ? and CURSOU = true");
            pstmt.setInt(1, aluno.getRA());
            rs = pstmt.executeQuery();
            conexao.desconectar();
            return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }

    public ResultSet buscaDisciplinas(Aluno aluno) {
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            pstmt = conn.prepareStatement("select * from NOTAS where RA = ? and CURSOU = false");
            pstmt.setInt(1, aluno.getRA());
            rs = pstmt.executeQuery();
            conexao.desconectar();
            return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }

}   


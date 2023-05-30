package fei_aluno;

public class Aluno {
    private int ra;
    private String nome;
    private String senha;
    private String login;
    //private String curso;

    public Aluno(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Aluno(String nome, int ra, String login, String senha) {
        this.nome = nome;
        this.ra = ra;
        this.login = login;
        this.senha = senha;
    }

    public int getRA() {
        return ra;
    }

    public String getNome() {
        return nome;
    }
       
    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
            
}

package fei_secretaria;

public class Aluno {
    private int ra;
    private String nome;
    private String senha;
    private String login;
    //private String curso;

    public Aluno(String nome, int ra, String login) {
        this.nome = nome;
        this.ra = ra;
        this.login = login;
        this.senha = "1234";
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

}

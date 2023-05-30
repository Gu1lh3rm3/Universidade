package fei_secretaria;

public class Disciplina {
    private String nome;
    private String codigo;
    private int semestre;
    private String professor;

    public Disciplina() {
    }

    public Disciplina(String nome, String codigo, int semestre, String professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.semestre = semestre;
        this.professor = professor;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getSemestre() {
        return semestre;
    }
    
    public String getProfessor() {
        return professor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
    
    
}

package fei_secretaria;

public class Nota extends Disciplina {
    private double media;
    private double A1;
    private double A2;

    public Nota() {
    }

    public double getA1() {
        return A1;
    }

    public double getA2() {
        return A2;
    }

    public double getMedia() {
        return media;
    }

    public void setA1(double A1) {
        this.A1 = A1;
    }

    public void setA2(double A2) {
        this.A2 = A2;
    }
    
    public void CalculaMedia(){
        this.media = (this.A1*0.3)+(this.A2*0.7);
    }
}

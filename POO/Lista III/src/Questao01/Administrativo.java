package Questao01;

public class Administrativo extends Assistente {
    protected String turno;
    protected double adicional;

    public Administrativo (String nome, double salario, int matricula, String turno, double adicional) {
        super(nome, salario, matricula);
        this.turno= turno;
        this.adicional= adicional;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getAdicional() {
        return adicional;
    }

    public void setAdicional(double adicional) {
        this.adicional = adicional;
    }

    @Override
    public void ganhoAnual() {
        
    }

    @Override
    public String toString() {
        String nome = String.format("Assistente Administrativo: [Nome= %s, Salario= R$%f, Matricula= %d, Turno= %s, Adicional= R$%f]", this.nome, this.salario, this.matricula, this.turno, this.adicional);
        return nome;
    }


}

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
    public double ganhoAnual() {
        return ((this.salario*12)+(this.adicional*12));
    }

    @Override
    public String toString() {
        String nome= String.format("Assistente Administrativo: [Nome= %s, Salario= R$%.2f, Matricula= %d, Turno= %s, Adicional= R$%.2f]", this.nome, this.salario, this.matricula, this.turno, this.adicional);
        return nome;
    }

    @Override //Bonus, de gratis
    public String exibeDados() {
        String dados= String.format("Me chamo %s, minha matricula é %d e recebo R$%.2f de salário!!\nEu trabalho no turno %s, por isso ganho um adicional de R$%.2f, totalizando R$%.2f por ano!!", this.nome, this.matricula,this.salario, this.turno, this.adicional, this.ganhoAnual());
        return dados;
    }

}
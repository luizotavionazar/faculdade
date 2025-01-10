package Questao01;

public class Tecnico extends Assistente {
    protected double bonusSal;

    public Tecnico (String nome, double salario, int matricula, double bonusSal) {
        super(nome, salario, matricula);
        this.bonusSal= bonusSal;
    }

    public double getBonusSal() {
        return bonusSal;
    }

    public void setBonusSal(double bonusSal) {
        this.bonusSal = bonusSal;
    }

    @Override
    public void ganhoAnual() {
        
    }
}

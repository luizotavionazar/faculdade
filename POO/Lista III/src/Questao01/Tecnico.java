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
    public double ganhoAnual() {
        return ((this.salario*12)+(this.bonusSal*12));
    }

    @Override
    public String toString() {
        String nome= String.format("Assistente Tecnico: [Nome= %s, Salario= R$%.2f, Matricula= %d, Bonus= R$%.2f]", this.nome, this.salario, this.matricula, this.bonusSal);
        return nome;
    }

    @Override //Bonus, de gratis
    public String exibeDados() {
        String dados= String.format("Me chamo %s, minha matricula é %d e recebo R$%.2f de salário!!\nEu tenho um bonus de R$%.2f, totalizando R$%.2f por ano!!", this.nome, this.matricula, this.salario, this.bonusSal, this.ganhoAnual());
        return dados;
    }

}

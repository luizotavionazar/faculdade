package Questao01;

public class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario (String nome, double salario) {
        this.nome= nome;
        this.salario= salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    protected double addAumento(double valor) {
        this.salario= this.salario+valor;
        System.out.println("O salário vai aumentar em R$"+valor+"!!");
        return this.salario;
    }

    protected double ganhoAnual() {
        return (this.salario*12);
    }

    protected String exibeDados() {
        String dados= String.format("Se chama %s e recebe R$%f de salário, totalizando R$%f por ano!!", this.nome, this.salario, this.ganhoAnual());
        return dados;
    }

    public void info() {
        System.out.println("Consultei meus superiores e as informações que obtivemos do Funcionario foi:\n"+this.exibeDados());
    }

    public void darAumento(double valor) {
        System.out.println("Consultei meus superiores e eles aceitaram o aumento para R$"+this.addAumento(valor)+" corrigindo então...\n"+this.exibeDados());
    }

}
package Parte2;

public class Gerente extends Funcionario{
    private double salario;

    public Gerente(String nome, double salario) {
        super(nome);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public double calcularSalario() {
        return this.salario;
    }
}
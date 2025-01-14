package Questao01;

public class Assistente extends Funcionario {
    protected int matricula;

    public Assistente (String nome, double salario, int matricula) {
        super(nome, salario);
        this.matricula= matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String exibeDados() {
        String dados= String.format("Me chamo %s, minha matricula é %d e recebo R$%f de salário, totalizando R$%f por ano!!", this.nome, this.matricula, this.salario, this.ganhoAnual());
        return dados;
    }

}
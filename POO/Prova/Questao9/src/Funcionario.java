public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, double salario) {
        super(nome);
        this.salario = salario;
    }

    @Override
    public void exibirNome() {
        System.out.println("Nome do Funcionário: " + nome);
    }

    public void exibirInformacoes() {
        exibirNome();
        System.out.println("Salário: " + salario);
    }

    public void trabalhar() {
        System.out.println("Funcionário está trabalhando");
    }
}
public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void exibirNome() {
        System.out.println("Nome: " + nome);
    }
}
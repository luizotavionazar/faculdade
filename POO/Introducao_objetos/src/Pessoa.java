public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private Carro carroPessoa;

    public void setNome(String nome) {
        this.nome= nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCpf(String cpf) {
        this.cpf= cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setIDade(int idade) {
        this.idade= idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setCarroPessoa(Carro carroPessoa) {
        this.carroPessoa= carroPessoa;
    }

    public Carro getCarroPessoa() {
        return this.carroPessoa;
    }

}
public class Hospede {
    private int cpf;
    private String endereco;
    private int telefone;

    public Hospede (int cpf, String endereco, int telefone) {
        this.cpf= cpf;
        this.endereco= endereco;
        this.telefone= telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public String endereco() {
        return endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "[Hospede= " + cpf + ", Endereço= " + endereco + ", Telefone= " + telefone + "]";
    }
    
}
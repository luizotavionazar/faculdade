public class Hospede {
    private String cpf, endereco, telefone;

    public Hospede (String cpf, String endereco, String telefone) {
        this.cpf= cpf;
        this.endereco= endereco;
        this.telefone= telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String endereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "[Hospede= " + cpf + ", Endereço= " + endereco + ", Telefone= " + telefone + "]";
    }
    
}

package ProgramaPessoas;

public class Adolescente extends Adulto{
    Adulto mae;

    public Adolescente(int idadePessoa, String nomePessoa, String cpfPessoa, Adulto adulto) {
        super(idadePessoa, nomePessoa, cpfPessoa);

        this.mae = adulto;
    }  

    public Adulto getMae() {
        return mae;
    }

    public void setMae(Adulto mae) {
        this.mae = mae;
    }

    @Override
    public void comer() {
        super.comer();
        System.out.println("O adolescente come dobrado");
    } 

    @Override
    public String toString() {
        return String.format("O adolescente %s tem idade %d, cpf %s e a mãe é %s", this.nomePessoa, this.idadePessoa, this.getCpf(), this.mae.getNomePessoa());
    }
}
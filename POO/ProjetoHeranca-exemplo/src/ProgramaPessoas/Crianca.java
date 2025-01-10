package ProgramaPessoas;

public class Crianca extends Pessoa{

    protected String certidaoNascimento;

    public Crianca(int idadePessoa, String nomePessoa, String certidaoNascimento) {
        //recebe o construtor da mãe
        super(idadePessoa, nomePessoa);
        this.certidaoNascimento = certidaoNascimento;
    }

    public String getCertidaoNascimento() {
        return certidaoNascimento;
    }

    public void setCertidaoNascimento(String certidaoNascimento) {
        this.certidaoNascimento = certidaoNascimento;
    }

   
    @Override
    public void comer() {
        super.comer(); //chamaria o mesmo método do pai
        System.out.println("Criança come papinha");
    }    
}
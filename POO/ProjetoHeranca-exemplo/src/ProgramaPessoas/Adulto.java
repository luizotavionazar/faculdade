package ProgramaPessoas;

//use o extends para herdar de outra classe

public class Adulto extends Pessoa{
    private String cpf;

    public Adulto(int idadePessoa, String nomePessoa, String cpfAdulto) {
        //na classe filha(subclasse) vocÊ deve inserir o super para chamar o construtor da classe pai
        super(idadePessoa, nomePessoa);

        //aqui foi adicionado um atributo a mais que só tem na classe filho
        this.cpf = cpfAdulto;
    }   

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //a notação @override significa que o método da classe mãe está sendo sobreescrito
    @Override
    public void comer() {
        System.out.println("O adulto come mais alimentos.");
    }

    @Override
    public String toString() {
        String nome = String.format("O adulto %s tem idade %d e o cpf %s", this.nomePessoa, this.idadePessoa, this.cpf);
        
        return nome;
    }
}
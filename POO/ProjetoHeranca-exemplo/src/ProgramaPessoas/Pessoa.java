package ProgramaPessoas;

//classe mãe - superclasse
public class Pessoa {

    protected int idadePessoa;
    protected String nomePessoa;

    // o construtor serve para definir quais atributos serão construídos com o
    // objeto
    public Pessoa(int idadePessoa, String nomePessoa) {
        // o this representa use os atributos dessa classe
        this.idadePessoa = idadePessoa;
        this.nomePessoa = nomePessoa;
    }

    // métodos get e set dão acesso aos atributos de maneira indireta
    public int getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(int idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    protected void comer() {
        System.out.println("Uma pessoa come");
    }
}
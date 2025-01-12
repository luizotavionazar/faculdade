package Questao04;

public class Novo extends Imovel{
    protected double valorAdicional;

    public Novo(String endereco, double preco, double valorAdicional) {
        super(endereco, preco);
        this.valorAdicional= valorAdicional;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void imprimeInfo() {
        System.out.println("Valor adicional do Imovel: R$"+valorAdicional);
    }

}
package Questao04;

public class Velho extends Imovel{
    protected double desconto;

    public Velho(String endereco, double preco, double desconto) {
        super(endereco, preco);
        this.desconto= desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void imprimeInfo() {
        System.out.println("Valor do desconto do Imovel: R$"+desconto);
    }
}
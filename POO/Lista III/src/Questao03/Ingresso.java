package Questao03;
public class Ingresso {
    protected double valor;

    public Ingresso(double valor) {
        this.valor= valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void imprimeValor() {
        System.out.println("Valor do ingresso: R$"+valor);
    }

}
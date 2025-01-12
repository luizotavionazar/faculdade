package Questao03;

public class Vip extends Ingresso{
    protected double valorAdicional;

    public Vip(double valor, double valorAdicional) {
        super(valor);
        this.valorAdicional= valorAdicional;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    @Override
    public void imprimeValor() {
        System.out.println("Valor do ingresso VIP: R$"+(valor+valorAdicional));
    }
    
}
package Questao03;

public class Normal extends Ingresso{
    public Normal(double valor) {
        super(valor);
    }

    @Override
    public void imprimeValor() {
        System.out.println("Valor do ingresso Normal: R$"+valor);
    }

}
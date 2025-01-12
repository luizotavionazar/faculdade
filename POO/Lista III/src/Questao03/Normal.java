package Questao03;

public class Normal extends Ingresso{
    public Normal(double valor) {
        super(valor);
    }

    @Override
    public void imprimeValor() {
        System.out.println("Ingresso Normal");
    }

}
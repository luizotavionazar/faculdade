package Parte3;

public class Eletronico extends Produto implements Pagamento{
    public Eletronico(String nome, double preco){
        super(nome, preco);
    }
    @Override
    public void processarPagamento(){
        double addperc=((getPreco()*10)/100);
        System.out.println("Pagamento processado: R$"+(addperc+getPreco()));
    }

}
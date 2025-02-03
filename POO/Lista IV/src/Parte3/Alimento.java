package Parte3;

public class Alimento extends Produto implements Pagamento{
    public Alimento(String nome, double preco){
        super(nome, preco);
    }
    @Override
    public void processarPagamento(){
        System.out.println("Pagamento processado: R$"+(getPreco()));
    }

}
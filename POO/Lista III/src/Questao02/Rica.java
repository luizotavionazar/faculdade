package Questao02;

public class Rica extends Pessoa{
    private double dinheiro;

    public void fazCompras(){
        System.out.println("Burguês safado gasta dinheiro atoa!!");
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

}
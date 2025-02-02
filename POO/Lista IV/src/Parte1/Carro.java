package Parte1;

public class Carro implements Veiculo {
    private int velocidade;

    public Carro() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        this.velocidade += 10;
        System.out.println("Acelerando o carro... " + this.velocidade + " Km/h");
    }

    @Override
    public void frear() {
        if (velocidade > 0) {
            this.velocidade -= 10;
            if (velocidade == 0) {
                System.out.println("O carro parou!!");
            } else {
                System.out.println("Freando o carro... " + this.velocidade + " Km/h");
            }
        } else {
            System.out.println("O carro já está parado!!");   
        }
    }

}
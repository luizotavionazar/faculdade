package Parte1;

public class Moto implements Veiculo {
    private int velocidade;

    public Moto() {
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        this.velocidade += 15;
        System.out.println("Acelerando a moto... " + this.velocidade + " Km/h");
    }

    @Override
    public void frear() {
        if (velocidade > 0) {
            this.velocidade -= 15;
            if (velocidade == 0) {
                System.out.println("A moto parou!!");
            } else {
                System.out.println("Freando a moto... " + this.velocidade + " Km/h");
            }
        } else {
            System.out.println("A moto já está parada!!");   
        }
    }

}
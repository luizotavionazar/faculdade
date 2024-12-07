public class Quarto {
    private int numeroQuarto;
    private double valorDiaria;

    public Quarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
        this.valorDiaria = (numeroQuarto % 2 == 0) ? 80 : 60; //Quartos pares: R$80,00 | Quartos impares: R$60,00
    }

    public int getNumero() {
        return numeroQuarto;
    }

    public double getValor() {
        return valorDiaria;
    }

    @Override
    public String toString() {
        return "[Quarto= " + numeroQuarto + ", Valor da Diária= R$" + valorDiaria;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
        
}

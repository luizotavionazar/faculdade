public class Quarto {
    private int numeroQuarto;
    private double valorDiaria;

    public Quarto (int numeroQuarto, double valorDiaria) {
        this.numeroQuarto= numeroQuarto;
        this.valorDiaria= valorDiaria;
    }

    public int getNumero() {
        return numeroQuarto;
    }

    public double getValor() {
        return valorDiaria;
    }

    @Override
    public String toString() {
        return "[Quarto= " + numeroQuarto + ", Valor= R$" + valorDiaria + "por Noite]";
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
        
}

public class Reserva {
    private Quarto quarto;
    private Hospede hospede;
    private double numeroDias;
    private String dataReserva;

    public Reserva (Quarto quarto, Hospede hospede, double numeroDias, String dataReserva) {
        this.quarto= quarto;
        this.hospede= hospede;
        this.numeroDias= numeroDias;
        this.dataReserva= dataReserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public double getNumDias() {
        return numeroDias;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    @Override
    public String toString() {
        return "[Reserva= " + quarto.getNumero() + ", Hospede= " + hospede.getCpf() + ", Prazo= " + numeroDias + ", Data Inicio: " + dataReserva + "]";
    }

}

import java.time.LocalDate;

public class Reserva {
    private int quarto;
    private String hospede;
    private int numeroDias;
    private LocalDate dataReserva;
    private LocalDate dataFim;
    private boolean status;

    public Reserva (int quarto, String hospede, int numeroDias, LocalDate dataReserva, LocalDate dataFim, boolean status) {
        this.quarto= quarto;
        this.hospede= hospede;
        this.numeroDias= numeroDias;
        this.dataReserva= dataReserva;
        this.dataFim= dataFim;
        this.status= status;
    }

    public int getQuarto() {
        return quarto;
    }

    public String getHospede() {
        return hospede;
    }

    public int getNumDias() {
        return numeroDias;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Reserva [Quarto=" + quarto + ", Hospede=" + hospede + ", Quantidade de Dias=" + numeroDias + ", Data da Reserva="+ dataReserva + ", Data Fim= "+dataFim+", Status= "+status+"]";
    }

}

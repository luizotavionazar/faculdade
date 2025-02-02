package Parte2;

public class Programador extends Funcionario{
    private double vlrHora;
    private float horasTrab;

    public Programador(String nome, double vlrHora, float horasTrab) {
        super(nome);
        this.vlrHora = vlrHora;
        this.horasTrab = horasTrab;
    }

    public double getVlrHora() {
        return vlrHora;
    }

    public float getHorasTrab() {
        return horasTrab;
    }

    @Override
    public double calcularSalario() {
        return this.vlrHora * this.horasTrab;
    }

}
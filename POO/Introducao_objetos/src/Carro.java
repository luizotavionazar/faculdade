public class Carro {
    private String modelo;
    private String placa;
    private int ano;

    public void setCarro(String modelo, String placa, int ano) {
        this.modelo= modelo;
        this.placa= placa;
        this.ano= ano;
    }
    
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
package Questao03;

public class CamaroteInferior extends Vip{
    protected String local;

    public CamaroteInferior(double valor, double valorAdicional, String local) {
        super(valor, valorAdicional);
        this.local= local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void imprimeInfo() {
        System.out.println("Camarote nº: "+local);
    }

}
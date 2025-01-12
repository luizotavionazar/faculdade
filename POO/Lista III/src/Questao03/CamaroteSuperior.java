package Questao03;

public class CamaroteSuperior extends Vip{
    protected String local;

    public CamaroteSuperior(double valor, double valorAdicional, String local) {
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
        System.out.println("Valor do Camarote Superior: R$"+(valor+valorAdicional));
    }

}
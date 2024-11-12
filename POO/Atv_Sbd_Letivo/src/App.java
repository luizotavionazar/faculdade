public class App {

    public void calculaIMC(Pessoa pessoa1, Pessoa pessoa2) {
        if (pessoa1!=null) {
            double altura= pessoa1.getAltura(), peso= pessoa1.getPeso();
            double imc= peso/(altura*altura);
            System.out.println("IMC da Pessoa: "+imc);
        } else {
            double altura= pessoa2.getAltura(), peso= pessoa2.getPeso();
            double imc= peso/(altura*altura);
            System.out.println("IMC da Pessoa: "+imc+"\n");
        }
    }

    public void exibirDetalhes(Pessoa pessoa1, Pessoa pessoa2) {
        App chamar= new App();

        System.out.println("\n"+"Objeto 1: "+pessoa1.toString());
        chamar.calculaIMC(pessoa1, null);
        
        System.out.println("\n"+"Objeto 2: "+pessoa2.toString());
        chamar.calculaIMC(null, pessoa2);
    }

    public static void main(String[] args) {
        App chamar= new App();
        Pessoa pessoa1= new Pessoa();
        Pessoa pessoa2= new Pessoa();

        pessoa1.setNome("Luiz");
        pessoa1.setIdade(22);
        pessoa1.setAltura(1.82);
        pessoa1.setPeso(90);

        pessoa2.setNome("Fulano");
        pessoa2.setIdade(20);
        pessoa2.setAltura(1.62);
        pessoa2.setPeso(55);

        chamar.exibirDetalhes(pessoa1, pessoa2);

    }
    
}
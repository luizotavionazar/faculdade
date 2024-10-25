public class Principal {
    public static void main(String[] args) {
        Pessoa luiz= new Pessoa();
        Pessoa jhonnie= new Pessoa();
        Pessoa alan= new Pessoa();

        luiz.setNome("Luiz Otávio");
        luiz.setCpf("67890543211");
        luiz.setIDade(22);
        luiz.setCarroPessoa(null);

        System.out.println("\nO "+luiz.getNome()+", que tem "+luiz.getIdade()+" anos, pertencente do CPF "+
            luiz.getCpf()+", não possui carro.\n");

        jhonnie.setNome("Jhonnie");
        jhonnie.setCpf("12345678901");
        jhonnie.setIDade(20);

        Carro carroJhonnie= new Carro();

        carroJhonnie.setModelo("Renegade");
        carroJhonnie.setAno(2017);
        carroJhonnie.setPlaca("QTD12424");

        jhonnie.setCarroPessoa(carroJhonnie);

        System.out.println("O "+jhonnie.getNome()+", que tem "+jhonnie.getIdade()+" anos, pertencente do CPF "+
            jhonnie.getCpf()+", possui o carro "+jhonnie.getCarroPessoa().getModelo()+" do ano de "+
            jhonnie.getCarroPessoa().getAno()+" com a placa "+jhonnie.getCarroPessoa().getPlaca()+".\n");

        alan.setNome("Alan Ferreira");
        alan.setCpf("10987654321");
        alan.setIDade(28);
        
        Carro carroAlan= new Carro();
        carroAlan.setCarro("Punto","JDH36749",2018);
        
        alan.setCarroPessoa(carroAlan);

        System.out.println("O "+alan.getNome()+", que tem "+alan.getIdade()+" anos, pertencente do CPF "+
            alan.getCpf()+", possui o carro "+alan.getCarroPessoa().getModelo()+" do ano de "+
            alan.getCarroPessoa().getAno()+" com a placa "+alan.getCarroPessoa().getPlaca()+".\n");
    }
}
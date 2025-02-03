import Parte1.*;
import Parte2.*;
import Parte3.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //PARTE 1
        Carro carro = new Carro();
        Moto moto = new Moto();

        carro.acelerar();
        carro.acelerar();
        carro.acelerar();
        carro.frear();
        carro.frear();
        carro.frear();
        carro.frear();
        System.out.println();

        moto.acelerar();
        moto.acelerar();
        moto.acelerar();
        moto.frear();
        moto.frear();
        moto.frear();
        moto.frear();
        System.out.println();

        //PARTE 2
        Funcionario igor = new Gerente("Igor de Oliveira", 15000);
        Funcionario luiz = new Programador("Luiz Otávio", 100, 12.5f);
        Funcionario jhonnie = new Programador("Jhonnie Gabriel", 150, 10);

        igor.exibirDados();
        System.out.println("Salário: R$" + igor.calcularSalario() + "\n");
        luiz.exibirDados();
        System.out.println("Salário: R$" + luiz.calcularSalario() + "\n");
        jhonnie.exibirDados();
        System.out.println("Salário: R$" + jhonnie.calcularSalario() + "\n");

        //PARTE 3
        Eletronico celular = new Eletronico("Galaxy gran prime", 700);
        Alimento pao = new Alimento("Pao de sal", 0.50);

        celular.exibirDetalhes();
        celular.processarPagamento();
        System.out.println();
        pao.exibirDetalhes();
        pao.processarPagamento();
        System.out.println();
    }
}
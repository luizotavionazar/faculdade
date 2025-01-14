package Questao05;

import java.util.Scanner;

import Questao01.*;
import Questao02.*;
import Questao03.*;
import Questao04.*;

public class Teste {
    public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    System.out.println("******************************************************************************************************************************************************************************************");
    System.out.println("                                                                    Lista III - Herança | Luiz Otávio Nazar");
    System.out.println("******************************************************************************************************************************************************************************************");
    System.out.println("\nA) Criar um assistente administrativo e um técnico. Imprimir o número da matricula e nome de cada um:");
    Administrativo jeremy = new Administrativo("Jeremy Antonio", 2410, 101, "noturno", 340);
    System.out.println(jeremy.toString());
    Tecnico cleide = new Tecnico("Cleide Gomes", 3422.50, 501, 250);
    System.out.println(cleide.toString());
    
    System.out.println("\nNº Matricula: "+jeremy.getMatricula()+", Nome: "+jeremy.getNome());
    System.out.println("Nº Matricula: "+cleide.getMatricula()+", Nome: "+cleide.getNome());
    
    System.out.println("\nB) Criar um animal do tipo cachorro e faze-lo latir. Criar um gato e faze-lo miar. Faze-los caminharem:");
    Cachorro iggy = new Cachorro();
    System.out.println(iggy.toString());
    Gato stray = new Gato();
    System.out.println(stray.toString());

    System.out.println("\n"+iggy.late());
    System.out.println(stray.mia());

    System.out.println("\n"+iggy.caminha());
    System.out.println(stray.caminha());

    System.out.println("\nC) Testar as clases Rica, Pobre e Miseravel como quiser. Cria e executa a ação de cada classe e define um Miseravel:");
    Pobre sereshumanos= new Pobre();
    sereshumanos.trabalha();
    Rica safados= new Rica();
    safados.fazCompras();
    Miseravel eu= new Miseravel();
    eu.mendiga();
    eu.setNome("Luiz");
    eu.setIdade(22);
    System.out.println("O "+eu.getNome()+" é um miserável de "+eu.getIdade()+" anos!!\n");
    System.out.println("Objetos "+sereshumanos.toString()+", "+safados.toString()+" e "+eu.toString()+" testados com Sucesso!!");

    System.out.println("\nD) Criar um Ingresso sendo 1 para Normal e 2 para VIP, e se VIP, 1 para camarote superior e 2 para inferior. Informar cada escolha do usuário. Imprimir o valor do ingresso:");
    boolean control= true;
    int opc=0, tmp1=0, tmp2=0;

    System.out.println("Ingresso #101");
    do {
        System.out.print("Tipo do Ingresso (1-Normal 2-VIP): ");
        opc= in.nextInt();
        switch (opc) {
            case 1:
                tmp1= 1;
                System.out.print("Tipo: Normal\n");
                control= true;
                break;

            case 2:
                tmp1= 2;
                System.out.print("Tipo: VIP\n");
                control= true;
                break;
        
            default:    
                System.out.println("Opção inválida!!");
                control= false;
                break;
        }
    } while (!control);
    
    if (opc==2) { //Se Tipo VIP
        do {
            System.out.print("Tipo do Camarote (1-Superior 2-Inferior): ");
            opc= in.nextInt();
            switch (opc) {
                case 1:
                    tmp2= 1;
                    System.out.print("Camarote: Superior\n");
                    control= true;
                    break;
    
                case 2:
                    tmp2= 2;
                    System.out.print("Camarote: Inferior\n");
                    control= true;
                    break;
            
                default:
                    System.out.println("Opção inválida!!");
                    control= false;
                    break;
            }
        } while (!control);
    }

    if (tmp1==1) { //Cria Ingresso Normal
        Normal ingresso= new Normal(80);
        ingresso.imprimeValor();
    } else { //Cria Ingresso VIP
        if (tmp2==1) { //Define a partir do Camarote
            Vip ingresso= new Vip(130, 100);
            ingresso.imprimeValor();
        } else {
            Vip ingresso= new Vip(130, 50);
            ingresso.imprimeValor();
        }
    }

    System.out.println("\nE) Criar um Imovel, sendo 1 para Novo e 2 para Velho. Exibir aa escolha do usuário e imprimir o valor final do Imovel:");
    System.out.println("Imovel #602");
    do {
        System.out.print("Qual Imovel deseja? (1-Novo 2-Velho): ");
        opc= in.nextInt();
        switch (opc) {
            case 1:
                tmp1= 1;
                System.out.print("Imovel: Novo\n");
                control= true;
                break;

            case 2:
                tmp1= 2;
                System.out.print("Imovel: Velho\n");
                control= true;
                break;
        
            default:
                System.out.println("Opção inválida!!");
                control= false;
                break;
        }
    } while (!control);
    
    if (tmp1==1) { //Cria o Imovel
        Novo imovel= new Novo("Rua da Conceição, 213, Centro, Paracatu-MG", 900, 250);
        System.out.println("Valor Total: R$"+(imovel.getPreco()+imovel.getValorAdicional()));
    } else {
        Velho imovel= new Velho("Rua da Benção, 512, Chapadinha, Paracatu-MG", 800, 30);
        System.out.println("Valor Total: R$"+(imovel.getPreco()+imovel.getDesconto()));
    }
    System.out.println("\n******************************************************************************************************************************************************************************************");
    System.out.println("                                                                    Não há mais nada a ser fazido... Obrigado!!");
    System.out.println("******************************************************************************************************************************************************************************************\n");

    System.out.println("    >>>> BÔNUS\n");
    System.out.println(jeremy.exibeDados()+"\n");
    System.out.println(cleide.exibeDados()+"\n");
    Assistente kleide= new Assistente("Kleide Pinto", 3250, 301);
    System.out.println(kleide.exibeDados()+"\n");
    Funcionario wilson= new Funcionario("Wilson Antenor", 1650);
    wilson.info();
    wilson.darAumento(3520);
    System.out.println("\n");

    in.close();
    }

}
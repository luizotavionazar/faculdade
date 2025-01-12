package Questao05;

import java.util.Scanner;

import Questao01.*;
import Questao02.*;
import Questao03.*;
import Questao04.*;

public class Teste {
    public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    System.out.println("\nA)");
    Administrativo jeremy = new Administrativo("Jeremy Antonio", 2410, 101, "noturno", 340);
    System.out.println(jeremy.toString());
    Tecnico cleide = new Tecnico("Cleide Gomes", 3422.50, 501, 250);
    System.out.println(cleide.toString());
    
    System.out.println("\nNº Matricula: "+jeremy.getMatricula()+", Nome: "+jeremy.getNome());
    System.out.println("Nº Matricula: "+cleide.getMatricula()+", Nome: "+cleide.getNome());
    
    System.out.println("\nB)");
    Cachorro iggy = new Cachorro();
    System.out.println(iggy.toString());
    Gato stray = new Gato();
    System.out.println(stray.toString());

    System.out.println("\n"+iggy.late());
    System.out.println(stray.mia());

    System.out.println("\n"+iggy.caminha());
    System.out.println(stray.caminha());

    System.out.println("\nC)");

    System.out.println("\nD)");
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

    System.out.println("\nE)");
    
    in.close();
    }

}
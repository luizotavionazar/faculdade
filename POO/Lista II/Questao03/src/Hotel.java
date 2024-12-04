import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Hotel {
    
    public void adicionarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR, float qtdDias, String dataReserva) {
        Scanner in= new Scanner(System.in);

        int quarto= 0, dia= 0, mes= 0, ano= 0, dias= 0;
        int cpf=0, telefone= 0; //avaliar um tipo que caiba o numero grande, transformar em vetor?
        String cidade= null, rua= null, bairro= null, numero= null;
        boolean control= true;
        
        System.out.println("    > Cadastro de Reserva\n");

        do { 
            control= false;
            do {
                for (int i = 1; i <= 4; i++) {
                    if (i==1 && dia==0) { System.out.print("Data Inicio: Dia..: "); } else if (i<=2 && mes==0) {
                                          System.out.print("             Mês..: "); } else if (i<=3 && ano==0) {
                                          System.out.print("             Ano..: "); } else if (i<=4 && dias==0) { 
                                          System.out.print("\nQtd Diárias.......: "); }
                    try {
                        if (i==1 && dia==0) { dia= in.nextInt(); control= true; } else if (i<=2 && mes==0) {
                                    mes= in.nextInt(); control= true; } else if (i<=3 && ano==0) {
                                    ano= in.nextInt(); control= true; } else if (i<=4 && dias==0) {
                                    dias= in.nextInt(); control= true; }
                    } catch (InputMismatchException e) {
                        System.out.println("\nInforme um valor válido!\n");
                        in.next();
                        control= false;
                        break;
                    }
                } 
            } while (!control);
        } while (!control);

        do {
            System.out.print("\n    > Número do quarto..: ");
                try {
                    quarto= in.nextInt();
                    control= true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control= false;
                }
        } while (!control);
        
        //AQUI Validar a disponibilidade do quarto

        System.out.println("    > Cadastro do Hospede\n");
        do {
            control=false;
            do {
                for (int i = 1; i <= 2; i++) {
                    if (i==1 && cpf==0) { System.out.print("     CPF..: "); } else if (i<=2 && telefone==0) {
                                          System.out.print("Telefone..: "); }
                    try {
                        if (i==1 && cpf==0) { cpf= in.nextInt(); control= true; } else if (i<=2 && telefone==0) {
                                    telefone= in.nextInt(); control= true; }
                    } catch (InputMismatchException e) {
                        System.out.println("\nInforme um valor válido!\n");
                        in.next();
                        control= false;
                        break;
                    }
                }
            } while (!control);
        } while (!control);

        System.out.println("-Endereço\n");
        for (int i = 1; i <= 4; i++) {
            if (i==1 && cidade==null) { System.out.print("Cidade..: "); } else if (i<=2 && rua==null) { //next bugou aqui, pedir ajuda pro jhonnie
                                            System.out.print("   Rua..: "); } else if (i<=3 && bairro==null) {
                                            System.out.print(" Bairro.: "); } else if (i<=4 && numero==null) {
                                            System.out.print(" Número.: "); }
            if (i==1 && cidade==null) { cidade= in.nextLine(); } else if (i<=2 && rua==null) {
                        rua= in.nextLine(); } else if (i<=3 && bairro==null) {
                        bairro= in.nextLine(); } else if (i<=4 && numero==null) {
                        numero= in.nextLine(); }
        }

        System.out.println(dia);
        System.out.println(mes);
        System.out.println(ano);
        System.out.println(dias);
        System.out.println(quarto);
        System.out.println(cpf);
        System.out.println(telefone);
        System.out.println(cidade);
        System.out.println(rua);
        System.out.println(bairro);
        System.out.println(numero);


    }

    public void cancelarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void procurarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void calcularReceita(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void listarReservas(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

}

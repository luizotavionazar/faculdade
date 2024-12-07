import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Hotel {
        public ArrayList<Quarto> quartos;
        public ArrayList<Hospede> hospedes;
        public Iterator<Quarto> iteratQ;
        public ArrayList<Reserva> reservas;
        public Iterator<Reserva> iteratR;
        public Iterator<Hospede> iteratH;
        Scanner in;
        
    public Hotel(Scanner in) {
        this.in= in;
        this.quartos = new ArrayList<>();
        this.hospedes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.iteratQ = quartos.iterator();
        this.iteratR = reservas.iterator();
        this.iteratH = hospedes.iterator();
    }

    public void adicionarReserva() {
        int quarto= 0;
        String cpf= null, telefone= null, tempData= null;
        String cidade= null, rua= null, bairro= null, numero= null;
        boolean control= true;
        DateTimeFormatter dataForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("\n >> CADASTRO DE RESERVA\n");

        System.out.print("Data Inicio (DD/MM/AAAA): ");
        in.nextLine(); tempData= in.nextLine();
        LocalDate data=LocalDate.parse(tempData, dataForm);

        System.out.print(" > Quantidade de Dias...: ");
        int qtdDias=in.nextInt();
        LocalDate dataFim=data.plusDays(qtdDias);

        do {
            System.out.print("\n > Número do Quarto.....: ");
                try {
                    quarto= in.nextInt();
                    control= true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control= false;
                }
        } while (!control);

        Quarto novoQuarto = new Quarto(quarto); //Cria o Quarto
        quartos.add(novoQuarto);
        iteratQ = quartos.iterator(); 
        
        //AQUI Validar a disponibilidade do quarto

        System.out.println("\n > Cadastro do Hospede");
        System.out.print("       CPF...: "); in.nextLine(); cpf= in.nextLine();
        System.out.print("  Telefone...: "); telefone= in.nextLine();
        System.out.println("  Endereço...:");
        System.out.print("    Cidade...: "); cidade= in.nextLine();
        System.out.print("       Rua...: "); rua= in.nextLine();
        System.out.print("    Bairro...: "); bairro= in.nextLine();
        System.out.print("    Número...: "); numero= in.nextLine();
        String endereco= cidade+", "+rua+", "+bairro+", "+numero;

        Hospede novoHospede = new Hospede(cpf, endereco, telefone); //Cria o Hospede
        hospedes.add(novoHospede);
        iteratH = hospedes.iterator();

        Reserva novaReserva = new Reserva(quarto, cpf, qtdDias, data, dataFim); //Cria a reserva
        reservas.add(novaReserva);
        iteratR = reservas.iterator();

        // Exibindo os quartos cadastrados após adicionar o novo quarto
        System.out.println("\nLista de Quartos:");
        while (iteratQ.hasNext()) { // Percorre a lista enquanto há elementos
            Quarto tempQuarto = iteratQ.next(); // Obtém o próximo elemento
            System.out.println(tempQuarto); // Exibe o quarto (invoca automaticamente o toString)
        }

        // Exibindo os hóspedes cadastrados
        System.out.println("\nLista de Hóspedes:");
        while (iteratH.hasNext()) { 
            Hospede tempHospede = iteratH.next();
            System.out.println(tempHospede);
        }

        // Exibindo as reservas
        System.out.println("\nLista de Reservas:");
        while (iteratR.hasNext()) { 
            Reserva tempReserva = iteratR.next();
            System.out.println(tempReserva);
        }

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

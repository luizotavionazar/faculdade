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
        int quarto= 0, qtdDias= 0;
        String cpf= null, telefone= null, tempData= null;
        String cidade= null, rua= null, bairro= null, numero= null;
        boolean control= true, quartoExis= false, hospedeExis= false;
        DateTimeFormatter dataForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data= null, dataFim= null;
        LocalDate hoje= LocalDate.now(); //Captura a data atual

        System.out.println("\n >> CADASTRO DE RESERVA\n");

        do {
            System.out.print("Data Inicio (DD/MM/AAAA): ");
            in.nextLine(); tempData = in.nextLine();
            data = LocalDate.parse(tempData, dataForm);
            if (data.isBefore(hoje)) { //Verifica se a data é menor que hoje
                System.out.println("\nData inválida! Deve ser Igual ou Maior que hoje\n");
                control= false;
            } else {
                control=true;
            }
        } while (!control);

        do {
            System.out.print(" > Quantidade de Dias...: ");
            try {
                qtdDias = in.nextInt();
                control = true;
            } catch (InputMismatchException e) {
                System.out.println("\nInforme um valor válido!\n");
                in.next();
                control = false;
            }
        } while (!control);
        dataFim = data.plusDays(qtdDias);
    
        do {
            System.out.print("\n > Número do Quarto.....: ");
            try {
                quarto = in.nextInt();
                control = true;
            } catch (InputMismatchException e) {
                System.out.println("\nInforme um valor válido!\n");
                in.next();
                control = false;
            }
        } while (!control);
        
        iteratQ = quartos.iterator();
        while (iteratQ.hasNext()) { //Verifica se o Quarto existe
            Quarto tempQuarto = iteratQ.next();
            if (tempQuarto.getNumero() == quarto) {
                quartoExis = true;
                break;
            }
        }

        if (!quartoExis) { //Cria o quarto se ele não existir
            Quarto novoQuarto = new Quarto(quarto);
            quartos.add(novoQuarto);
        }
    
        //Verificar a disponibilidade do quarto aqui

        System.out.println("\n > Cadastro do Hospede");
        System.out.print("       CPF...: "); in.nextLine(); cpf = in.nextLine();
        
        iteratH = hospedes.iterator();
        while (iteratH.hasNext()) { //Verifica se o hospede existe
            Hospede tempHospede = iteratH.next();
            if (tempHospede.getCpf().equals(cpf)) {
                hospedeExis = true;
                break;
            }
        }
        
        if (!hospedeExis) { // Cria o hóspede se ele não existir
            System.out.print("  Telefone...: "); telefone = in.nextLine();
            System.out.println("  Endereço...:");
            System.out.print("    Cidade...: "); cidade = in.nextLine();
            System.out.print("       Rua...: "); rua = in.nextLine();
            System.out.print("    Bairro...: "); bairro = in.nextLine();
            System.out.print("    Número...: "); numero = in.nextLine();
            String endereco = cidade + ", " + rua + ", " + bairro + ", " + numero;
            Hospede novoHospede = new Hospede(cpf, endereco, telefone);
            hospedes.add(novoHospede);
        }
        
        Reserva novaReserva = new Reserva(quarto, cpf, qtdDias, data, dataFim); //Cria a Reserva
        reservas.add(novaReserva); 
        
        // Exibe a lista de quartos
        System.out.println("\nLista de Quartos:");
        iteratQ = quartos.iterator(); // Reinicializa o iterador para os quartos
        while (iteratQ.hasNext()) {
            Quarto tempQuarto = iteratQ.next();
            System.out.println(tempQuarto);
        }
        
        // Exibe a lista de hóspedes
        System.out.println("\nLista de Hóspedes:");
        iteratH = hospedes.iterator(); // Reinicializa o iterador para os hóspedes
        while (iteratH.hasNext()) {
            Hospede tempHospede = iteratH.next();
            System.out.println(tempHospede);
        }
    }

    public void cancelarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void procurarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void calcularReceita(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void listarReservas() {
        System.out.println("\nLista de Reservas:");
        while (iteratR.hasNext()) { 
            Reserva tempReserva = iteratR.next();
            System.out.println(tempReserva);
        }
    }

}

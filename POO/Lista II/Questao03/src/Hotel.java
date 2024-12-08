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
        LocalDate hoje= LocalDate.now(); //Captura a data atual para validação

        System.out.println("\n >> CADASTRO DE RESERVA\n");

        in.nextLine();
        do {
            System.out.print(" > Data Inicio (DD/MM/AAAA): ");
            try {
                tempData = in.nextLine();
                data = LocalDate.parse(tempData, dataForm);
                if (data.isBefore(hoje)) { //Verifica se a data é menor que hoje
                    System.out.println("Data inválida, deve ser maior ou igual à hoje!!\n");
                    control= false;
                } else {
                    control=true;
                }
            } catch (Exception e) {
                System.out.println("Formato de Data inválida, verifique a inserção!!\n");
                control= false;
            }
        } while (!control);

        do {
            System.out.print(" > Quantidade de Dias......: ");
            try {
                qtdDias = in.nextInt();
                control = true;
            } catch (InputMismatchException e) {
                System.out.println("Informe um valor válido!\n");
                in.next();
                control = false;
            }
        } while (!control);
        dataFim = data.plusDays(qtdDias); //Define a Data de Fim da Reserva
    
        do {
            quartoExis = false;
            control = true;
            do {
                System.out.print("\n > Número do Quarto........: ");
                try {
                    quarto = in.nextInt();
                    control = true;
                } catch (InputMismatchException e) {
                    System.out.println("Informe um valor válido!\n");
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
    
            if (!reservas.isEmpty()) { //Se já existir outras reservas, encontra e armazena a Data Fim mais longe do mesmo quarto, para validar o quarto corretamente
                Reserva tempTempRes= null;
                iteratR = reservas.iterator(); //Itera para encontrar a Reserva do mesmo quarto
                while (iteratR.hasNext()) {
                    Reserva tempReserva= iteratR.next();
                    if (tempTempRes==null && tempReserva.getQuarto()==quarto) {
                        iteratR = reservas.iterator(); //Itera novamente para encontrar a reserva com Data Fim mais distante
                        while (iteratR.hasNext()) {    
                            tempTempRes = iteratR.next();
                            if (tempTempRes.getQuarto()==tempReserva.getQuarto() && //Anotação: Encerra quando a Data Inicial preenchida é antes da Data Inicial da outra reserva do mesmo quarto e a Data Fim é igual ou mais distante
                                (tempTempRes.getDataFim().isEqual(tempReserva.getDataFim()) ||
                                tempTempRes.getDataFim().isAfter(tempReserva.getDataFim()))) {
                                break;
                            }
                        }
                    } 
                }

                iteratR = reservas.iterator(); //Itera novamente para validar se o quarto já está reservado
                while (iteratR.hasNext()) {
                    Reserva tempReserva = iteratR.next();
                    if (tempReserva.getQuarto()==quarto) {
                        if (tempReserva.getStatus()) { //Verifica se a Reserva do quarto está ativa
                            if (!(tempReserva.getDataFim().isBefore(data) ||
                                tempReserva.getDataReserva().isAfter(dataFim))) {
                                System.out.println("Quarto já reservado até "+tempTempRes.getDataFim().format(dataForm)+", escolha outro!!"); //Exibe a Data Fim mais distante do quarto naquele periodo
                                control= false;
                                break;
                            }
                        } else { //QUANDO ENCONTRADA RESERVA PARA O QUARTO MAS FOI CANCELADA, PROSSEGUE
                            control= true;
                            break;
                        }
                    }
                }
            }
        } while (!control);

        System.out.println("\n > Seleção do Hospede");

        in.nextLine();
        do { //Inserção e validação do CPF
            System.out.print("   CPF........: "); cpf = in.nextLine();
                    cpf= cpf.replaceAll("[.\\-\\s]", ""); //Remove caracteres especiais
                    //Anotação: \\s: Representa qualquer espaço em branco. Incluindo: Espaços, Tabulação, Quebras de linha
                    //Anotação: \\-: O '-' precisa ser sucessor a barra invertida pois, somente o traço, é interpretado como um intervalo de caracteres.
                    
                    if (cpf.length() != 11 || !cpf.matches("\\d+")) { //Valida se tem 11 dígitos e a inserção de caractere não númericos
                        System.out.println("CPF Inválido, verifique a quantidade e os caracteres inseridos!\n");
                        control= false;
                    } else if (cpf.chars().distinct().count() == 1) { //Verifica se os digitos do CPF são iguais
                        System.out.println("CPF Inválido, verifique a inserção!\n");
                        control= false;
                    } else { //CPF Válido
                        control= true;
                    }
        } while (!control);
        
        iteratH = hospedes.iterator();
        while (iteratH.hasNext()) { //Verifica se o hospede existe
            Hospede tempHospede = iteratH.next();
            if (tempHospede.getCpf().equals(cpf)) {
                hospedeExis = true;
                break;
            }
        }
        
        if (!hospedeExis) { //Cria o hóspede se ele não existir
            System.out.print("   Telefone...: "); telefone = in.nextLine();
            System.out.print("   Endereço | Cidade.....: "); cidade = in.nextLine();
            System.out.print("                 Rua.....: "); rua = in.nextLine();
            System.out.print("              Bairro.....: "); bairro = in.nextLine();
            System.out.print("              Número.....: "); numero = in.nextLine();
            String endereco = "Cidade: " + cidade + ", Rua: " + rua + ", Bairro: " + bairro + ", Número: " + numero;
            Hospede novoHospede = new Hospede(cpf, endereco, telefone);
            hospedes.add(novoHospede);
        }
        
        Reserva novaReserva = new Reserva(quarto, cpf, qtdDias, data, dataFim,true); //Cria a Reserva
        reservas.add(novaReserva);
        
        System.out.println("\n >> RESERVA CADASTRADA COM SUCESSO");

        //System.out.println("\nLista de Quartos:");
        //iteratQ = quartos.iterator();
        //while (iteratQ.hasNext()) {
        //    Quarto tempQuarto = iteratQ.next();
        //    System.out.println(tempQuarto);
        //}
        //
        //System.out.println("\nLista de Hóspedes:");
        //iteratH = hospedes.iterator();
        //while (iteratH.hasNext()) {
        //    Hospede tempHospede = iteratH.next();
        //    System.out.println(tempHospede);
        //}
    }

    public void cancelarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void procurarReserva(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void calcularReceita(ArrayList<Reserva> reservas, Iterator<Reserva> iteratR) {
        
    }

    public void listarReservas() {
        System.out.println("\nLista de Reservas:");
        iteratR = reservas.iterator();
        while (iteratR.hasNext()) { 
            Reserva tempReserva = iteratR.next();
            System.out.println(tempReserva);
        }
    }

}

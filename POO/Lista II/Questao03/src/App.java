import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    public void menu() {
        System.out.println("\n            HOTEL DO GAGUIN\n");
        System.out.println("  1 > Nova reserva");
        System.out.println("  2 > Encerrar reserva");
        System.out.println("  3 > Buscar reserva");
        System.out.println("  4 > Receita total");
        System.out.println("  5 > Reservas ativas");
        System.out.println("  6 > Sair\n");
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        App chamarMain= new App();
        Hotel chamarHotel= new Hotel();
        ArrayList<Quarto> quartos= new ArrayList<>();
        ArrayList<Hospede> hospedes= new ArrayList<>();
        ArrayList<Reserva> reservas= new ArrayList<>();
        Iterator<Quarto> iteratQ= quartos.iterator();
        Iterator<Hospede> iteratH= hospedes.iterator();
        Iterator<Reserva> iteratR= reservas.iterator();

        boolean control= true, control1= true;
        int opc= 0;

        while (control) {
            chamarMain.menu();
            do {
                System.out.print("Escolha a opção desejada: ");
                try {
                    opc= in.nextInt();
                    control1= true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control1= false;
                }
                
            } while (!control1);
    
            switch (opc) {
                case 1:
                    chamarHotel.adicionarReserva(reservas, iteratR, 0, "");
                    break;
    
                case 2:
                    chamarHotel.cancelarReserva(reservas, iteratR);
                    break;
    
                case 3:
                    chamarHotel.procurarReserva(reservas, iteratR);
                    break;
                
                case 4:
                    chamarHotel.calcularReceita(reservas, iteratR);
                    break;
                
                case 5:
                    chamarHotel.listarReservas(reservas, iteratR);
                    break;

                case 6:
                    control= false;
                    System.out.println("");
                    break;
    
                default:
                    System.out.println("\nOpção inválida!");
                    break;
    
            }
        }

        in.close();
    }

}

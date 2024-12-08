import java.util.InputMismatchException;
import java.util.Scanner;

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
        Hotel chamarHotel= new Hotel(in);

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
                    System.out.println("Informe um valor válido!\n");
                    in.next();
                    control1= false;
                }
                
            } while (!control1);
    
            switch (opc) {
                case 1:
                    chamarHotel.adicionarReserva();
                    break;
    
                case 2:
                    chamarHotel.cancelarReserva();
                    break;
    
                case 3:
                    chamarHotel.procurarReserva();
                    break;
                
                case 4:
                    chamarHotel.calcularReceita();
                    break;
                
                case 5:
                    chamarHotel.listarReservas();
                    break;

                case 6:
                    control= false;
                    System.out.println("");
                    break;
    
                default:
                    System.out.println("Opção inválida!");
                    break;
    
            }
        }

        in.close();
    }

}

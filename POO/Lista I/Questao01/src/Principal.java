import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    public void menu() {
        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("         MENU PRODUTO");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("  1 > Cadastrar");
        System.out.println("  2 > Informações");
        System.out.println("  3 > Calcular Valor Total");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n");
    }

    public void exibirDetalhes() {

    }
    
    public void calcularTotal() {
        
    }

    public static void main(String[] args) throws Exception {
        Scanner in= new Scanner(System.in);
        Principal chamar= new Principal();
        Produto produto= new Produto();
        boolean control= true;
        int opc= 0;


        chamar.menu();

        do {
            System.out.println("Escolha a opção desejada: ");
            try {
                opc= in.nextInt();
                System.out.println("\n");
                control= true;
            } catch (InputMismatchException e) {
                System.out.println("\n");
                System.out.println("              Informe um valor válido!");
                in.next();
                control=false;}} while (!control);

        switch (opc) {
            case 1:
                
                break;
        
            case 2:

                break;

            case 3:
                
                break;

            default:
                break;
                
        }

        in.close();
    }
}
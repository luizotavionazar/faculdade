import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    public void menu() {
        System.out.println("\n            GESTÃO DE FUNCIONARIOS\n");
        System.out.println("  1 > Adicionar funcionário");
        System.out.println("  2 > Exibir funcionários");
        System.out.println("  3 > Calcular média salarial da empresa");
        System.out.println("  4 > Buscar funcionarios por cargo especifico");
        System.out.println("  5 > Sair\n");
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        App chamarMain= new App();
        Empresa chamarEmpresa= new Empresa();
        ArrayList<Funcionario> funcionarios= new ArrayList<>();
        Iterator<Funcionario> iterat= funcionarios.iterator();

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
                    chamarEmpresa.adicionarFunc(funcionarios);
                    break;
    
                case 2:
                    chamarEmpresa.exibirFunc(funcionarios, iterat);  
                    break;
    
                case 3:
                    chamarEmpresa.calcularMediaSal(funcionarios, iterat);
                    break;
                
                case 4:
                    chamarEmpresa.buscarFunc(funcionarios, iterat);
                    break;

                case 5:
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
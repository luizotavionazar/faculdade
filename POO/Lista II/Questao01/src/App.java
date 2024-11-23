import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    public void menu() {
        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("           BIBLIOTECA");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("  1 > Adicionar livro");
        System.out.println("  2 > Exibir livros");
        System.out.println("  3 > Buscar livros por autor");
        System.out.println("  4 > Buscar livros por ano de publicação");
        System.out.println("  5 > Sair");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n");
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        App chamarMain= new App();
        Biblioteca chamarBiblioteca= new Biblioteca();
        ArrayList<Livro> livros= new ArrayList<>();
        Iterator<Livro> iterat= livros.iterator();

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
                    if (chamarBiblioteca.adicionarLivro(livros, iterat)) {
                        System.out.println("Livro cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possivel cadastrar o livro...");
                    }
                    break;
    
                case 2:
                    
                    break;
    
                case 3:
                    
                    break;
                
                case 4:
                 
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
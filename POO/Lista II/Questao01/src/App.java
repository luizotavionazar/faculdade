import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    public void menu() {
        System.out.println("\n                  BIBLIOTECA\n");
        System.out.println("  1 > Adicionar livro");
        System.out.println("  2 > Exibir livros");
        System.out.println("  3 > Buscar livros por autor");
        System.out.println("  4 > Buscar livros por ano de publicação");
        System.out.println("  5 > Sair\n");
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
                    chamarBiblioteca.adicionarLivro(livros);
                    break;
    
                case 2:
                    chamarBiblioteca.exibirLivros(livros, iterat);  
                    break;
    
                case 3:
                    chamarBiblioteca.buscarLivro(livros, iterat, "T");
                    break;
                
                case 4:
                    chamarBiblioteca.buscarLivro(livros, iterat, "A");
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
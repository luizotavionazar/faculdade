import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Biblioteca {
    

    public void adicionarLivro(ArrayList<Livro> livros) {
        Scanner in= new Scanner(System.in);

        String titulo, autor;
        int anoPublicacao;
        boolean control;
        
        System.out.print("\nTitulo do livro...: ");
        titulo= in.nextLine();
        System.out.print("Autor do livro....: ");
        autor= in.nextLine();

        do {
            System.out.print("Ano de publicação.: ");
                try {
                    anoPublicacao= in.nextInt();
                    livros.add(new Livro(titulo, autor, anoPublicacao));
                    control= true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control= false;
                }
            } while (!control);
    }   

    public void exibirLivros(ArrayList<Livro> livros, Iterator<Livro> iterat) {
        iterat= livros.iterator();

        while (iterat.hasNext()) {
            Livro exemplar= iterat.next();
            System.out.println("\n"+exemplar);
        }

    }

    public void buscarLivro(ArrayList<Livro> livros, Iterator<Livro> iterat, String tipo) {
        Scanner in= new Scanner(System.in);
        iterat= livros.iterator();
        String autor= null;
        int anoPublicacao= 0;
        boolean control;

        System.out.print("\n> Pesquisa por "); if (tipo.equals("T")){System.out.println("Autor");} else {System.out.println("Ano de Publicação");}
        
        if (tipo.equals("T")) {
            System.out.print("Informe o nome do Autor.: ");
            autor= in.nextLine();
        } else {
            do {
                System.out.print("Informe o Ano de Publicação.: ");
                    try {
                        anoPublicacao= in.nextInt();
                        control= true;
                    } catch (InputMismatchException e) {
                        System.out.println("\nInforme um valor válido!\n");
                        in.next();
                        control= false;
                    }
                } while (!control);
        }
        
        while (iterat.hasNext()) {
            Livro exemplar = iterat.next(); // Obtém o próximo livro da lista
            if (tipo.equals("T")) {
                if (exemplar.getAutor().equalsIgnoreCase(autor)) { // Verifica o autor
                    System.out.print("\nLivro encontrado: "+exemplar+"\n");
                }
            } else {
                if (exemplar.getAnoPublicacao()==anoPublicacao) { // Verifica o ano de publicação
                    System.out.print("\nLivro encontrado: "+exemplar+"\n");
                }
            }
        }
    }

}
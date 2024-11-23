import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Biblioteca {
    

    public boolean adicionarLivro(ArrayList<Livro> livros, Iterator<Livro> iterat) {
        Scanner in= new Scanner(System.in);
        
        iterat= livros.iterator();
        String titulo, autor;
        int anoPublicacao;
        boolean control;
        
        System.out.println("Titulo do livro...: ");
        titulo= in.nextLine();
        System.out.println("Autor do livro....: ");
        autor= in.nextLine();
        System.out.println("Ano de publicação.: ");

        do {
                System.out.print("Escolha a opção desejada: ");
                try {
                    anoPublicacao= in.nextInt();
                    livros.add(new Livro(titulo, autor, anoPublicacao));
                    control= true;
                    return true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control= false;
                    return false;
                }
            } while (!control);
    }

    
}
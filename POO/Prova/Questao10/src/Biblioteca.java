import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {
    private ArrayList<String> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(String livro) {
        livros.add(livro);
    }

    public void exibirLivros() {
        Iterator<String> iterator = livros.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
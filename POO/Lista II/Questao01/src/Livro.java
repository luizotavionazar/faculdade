public class Livro {
    private String titulo= null;
    private String autor= null;
    private int anoPublicacao= 0;

    public Livro (String titulo, String autor, int anoPublicacao) {
        this.titulo= titulo;
        this.autor= autor;
        this.anoPublicacao= anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}
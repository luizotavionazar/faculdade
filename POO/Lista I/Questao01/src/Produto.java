public class Produto {
    private String nome;
    private float preco;
    private float quantidade;

    public void setProduto(String nome, float preco, float quantidade) {
        this.nome= nome;
        this.preco= preco;
        this.quantidade= quantidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
}
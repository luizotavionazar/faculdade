public class Produto {
    private String descricao;
    private float preco;
    private float quantidade;

    public void setProduto(String descricao, float preco, float quantidade) {
        this.descricao= descricao;
        this.preco= preco;
        this.quantidade= quantidade;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
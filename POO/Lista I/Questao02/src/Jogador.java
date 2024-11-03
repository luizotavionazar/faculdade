public class Jogador {
    private String nome;
    private float pontos;
    private float energia;

    public void setJogador(String nome, float pontos, float energia) {
        this.nome= nome;
        this.pontos= pontos;
        this.energia= energia;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPontos() {
        return pontos;
    }
    public void setPontos(float pontos) {
        this.pontos = pontos;
    }
    public float getEnergia() {
        return energia;
    }
    public void setEnergia(float energia) {
        this.energia = energia;
    }
}
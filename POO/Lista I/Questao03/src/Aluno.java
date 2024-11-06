public class Aluno {
    private String nome;
    private float idade;
    private float nota1;
    private float nota2;

    public void setJogador(String nome, float idade, float nota1, float nota2) {
        this.nome= nome;
        this.idade= idade;
        this.nota1= nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getIdade() {
        return idade;
    }
    public void setIdade(float idade) {
        this.idade = idade;
    }
    public float getnota1() {
        return nota1;
    }
    public void setnota1(float nota1) {
        this.nota1 = nota1;
    }
    public float getnota2() {
        return nota2;
    }
    public void setnota2(float nota2) {
        this.nota2 = nota2;
    }
}
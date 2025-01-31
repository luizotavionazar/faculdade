public class Main {
    public static void main(String[] args) {
        //Animal animal= new Animal(); < Erro, pq é abstrato
        Cachorro cachorro= new Cachorro();
        cachorro.emitirSom();
        cachorro.dormir();
    }
}
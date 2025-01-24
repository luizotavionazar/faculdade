public class Cachorro extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("Cachorro late");
    }

    public void correr() {
        System.out.println("Cachorro está correndo");
    }
}
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.remove(1);
        System.out.println(lista);
    }
} 
import java.util.ArrayList;
import java.util.Scanner;

public class Atv5 {
    public static void ordenacao(ArrayList<Integer> numeros) {
        int tamanho= numeros.size();
        boolean control= true;

        for (int i = 0; i < tamanho-1; i++) {
            control= false;

            for (int j = 0; j < tamanho-1; j++) {

                if (numeros.get(j)>numeros.get(j+1)) {
                    int numero= numeros.get(j);
                    numeros.set(j, numeros.get(j+1));
                    numeros.set(j+1, numero);
                    control= true;
                }

            }

            if (!control) { break; }
        }

    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        boolean control= true;
        ArrayList<Integer> numeros= new ArrayList<>();

        System.out.println("");
        System.out.println("Informe números variados, eles serão ordenados em ordem crescente!");
        System.out.println(" > Digite 'sair' para encerrar o preenchimento.");

        System.out.println("");

        while (control) {
            
            try {
                System.out.print("Números: ");
                int num= in.nextInt();
                numeros.add(num);
            } catch (Exception e) {
                control= false; 
            }

        }

        ordenacao(numeros);

        System.out.println("");
        System.out.println("Números em ordem:");
        
        System.out.print(" > ");
        for (Integer numero : numeros) {
            System.out.print(numero+", ");
        }

        System.out.println("\n");

        in.close();
    }
}
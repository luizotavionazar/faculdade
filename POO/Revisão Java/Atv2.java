import java.util.ArrayList;
import java.util.Scanner;

public class Atv2 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        ArrayList<Integer> numeros= new ArrayList<>();
        boolean control= true;
        int soma=0, seq= 0;

        System.out.println("");
        System.out.println("Informe os números que deseja somar, digite 'sair' para encerrar:");
        System.out.println("");

        while (control) {
            System.out.print((seq+1)+"º Valor: ");

            try {
                numeros.add(in.nextInt());
                soma= soma+numeros.get(0);
                numeros.remove(0);
                seq++;
            } catch (Exception e) {
                control= false;
            }

        }

        System.out.println("");
        System.out.println("Soma final: "+soma);
        System.out.println("");

        in.close();
    }
}
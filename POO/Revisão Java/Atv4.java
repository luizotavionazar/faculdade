import java.util.Scanner;
import java.util.StringTokenizer;

public class Atv4 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String frase= null;

        System.out.println("");
        System.out.println("Escreva uma frase, será contada quantas palavras ela possui!");

        System.out.println("");
        System.out.print("Frase: ");
        frase= in.nextLine();

        StringTokenizer separador= new StringTokenizer(frase, " ,!@?:;./|=+-()*&¨%$#'>s<[]^~°ºª§{}_");

        System.out.println("");
        System.out.println("Quantidade de palavras: "+separador.countTokens());
        System.out.println("");

        in.close();
    }
}
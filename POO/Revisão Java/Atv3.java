import java.util.Scanner;

public class Atv3 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String frase= null;
        char[] vogais= {'A','E','I','O','U'};
        int[] qtdVogais= new int[5];
        int qtdTotal= 0;

        System.out.println("");
        System.out.println("Escreva uma frase, será contada quantas vogais ela tem!");

        System.out.println("");
        System.out.print("Frase: ");
        frase= in.nextLine();

        for (int i= 0; i < frase.length(); i++) {
            char teste= frase.charAt(i);
            char letra= Character.toUpperCase(teste);

            for (int j= 0; j < qtdVogais.length; j++) {
                if (letra==vogais[j]) {
                    qtdVogais[j]++; 
                    qtdTotal++;
                    break; }
            }
        }

        System.out.println("");
        System.out.println("Sua frase possui "+qtdTotal+" vogais, sendo elas:");

        for (int i= 0; i < qtdVogais.length; i++) {
            if (qtdVogais[i]>0) {
                if (i<qtdVogais.length-1) {
                    System.out.print(qtdVogais[i]+" letras "+vogais[i]+", "); }
                    else {
                        System.out.print("e "+qtdVogais[i]+" letras "+vogais[i]); }
            }
        }
        
        System.out.println("\n");

        in.close();
    }
}
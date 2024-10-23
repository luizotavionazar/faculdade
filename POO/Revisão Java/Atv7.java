import java.util.Scanner;

public class Atv7 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int num= 0;
        String conversao= "";
        boolean control= false;

        System.out.println("");
        System.out.println("Informe um valor decimal positivo que irei converte-lo para binário!");

        System.out.println("");
        
        while (!control) {
            System.out.print("Número: ");
            num= in.nextInt();

            if (num<0) {
                System.out.println("");
                System.out.println("Informe um valor POSITIVO!");
                System.out.println("");
            } else {
                control= true;
            }

        }

        if (num==0) {
            conversao= "0";
        }
        else {
            while (num>0) {
                conversao= (num%2)+conversao;
                num= num/2;
            }
        }

        System.out.println("");
        System.out.println("Número em binário: "+conversao);
        System.out.println("");

        in.close();
    }
}
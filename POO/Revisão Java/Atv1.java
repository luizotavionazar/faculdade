import java.util.Scanner;

public class Atv1 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int num= 0, qtd= 1;
        float media= 0, soma= 0;
        boolean control= true;

        System.out.println("");
        System.out.println("Informe os numeros que deseja obter a média, digite 'sair' para encerrar:");
        System.out.println("");

        while (control) {
            System.out.print("Informe o "+qtd+"º valor: ");
            
            try {
                num= in.nextInt();
                soma= soma+num;
                qtd++;
            } catch (Exception e) {
                control= false; 
            }
            
        }
        
        media= soma/(qtd-1);
        System.out.println("");
        System.out.println("Média final: "+media); 
        
        in.close();
    }
}
import java.util.Scanner;

public class Atv6 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int maior= 0;

        System.out.println("");
        System.out.println("Crie uma tabela e preencha a mesma, irei encontrar o maior valor preenchido!");

        System.out.println("");
        System.out.print("Deseja quantas linhas na tabela? ");
        int linha= in.nextInt();

        System.out.print("E quantas colunas? ");
        int coluna= in.nextInt();

        int [][] matriz= new int[linha][coluna];
        System.out.println("");
        
        for (int i= 0; i < linha; i++) {
            for (int j= 0; j < coluna; j++) {
                System.out.print("Valor da linha ["+(i+1)+"], coluna ["+(j+1)+"]: ");
                matriz[i][j]= in.nextInt();
            }
        }

        System.out.println("");
        System.out.println("Tabela final:");

        for (int i= 0; i < linha; i++) {
            System.out.print(" > ");
            for (int j= 0; j < coluna; j++) {
                System.out.print(matriz[i][j]+" ");

                if (i>0&&j>0) {

                    if (matriz[i][j]>matriz[(i-1)][(j-1)]) {
                        if (matriz[i][j]>maior) {
                            maior= matriz[i][j];    
                        }
                    } 
                    
                    else if (matriz[(i-1)][(j-1)]>maior) {
                            maior= matriz[(i-1)][(j-1)];
                    }
                    
                }

            }
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("O maior valor é: "+maior);
        System.out.println("");

        in.close();
    }
}
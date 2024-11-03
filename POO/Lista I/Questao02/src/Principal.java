import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public void menu(Jogador jogador) {
        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("     MENU - ATAQUE MALUCO");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("  1 > Cadastrar jogador");

        if (jogador.getNome()!=null) {
            System.out.println("  2 > Estatisticas");
        }

        System.out.println("  4 > Sair");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n");
    }
    
    public Jogador cadastrarJog(Jogador jogador) {


        return jogador;
    }
    
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        Jogador jogador= new Jogador();
        Principal chamar= new Principal();
        boolean control= true, control1= true;
        int opc= 0;

        while (control) {
            chamar.menu(jogador);
            do {
                System.out.print("Escolha a opção desejada: ");
                try {
                    opc = in.nextInt();
                    control1 = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control1 = false;
                }
                
            } while (!control1);
    
            switch (opc) {
                case 1:
                    jogador = chamar.cadastrarJog(jogador);
                    break;
    
                case 2:
                    if (produto.getDescricao()=="null"|| //Para cair no else
                        produto.getDescricao()!=null) {  //Para entrar no metodo
                        chamar.exibirDetalhes(produto); 
                    }
                    else {
                        System.out.println("\nNecessário cadastrar o produto para acessar essa opção!");
                    }
                    break;
    
                case 3:
                    if (produto.getDescricao()=="null"||
                        produto.getDescricao()!=null) {
                        chamar.calcularTotal(produto);
                    }
                    else {
                        System.out.println("\nNecessário cadastrar o produto para acessar essa opção!");
                    }
                    break;

                case 4:
                    control= false;
                    System.out.println("");
                    break;
    
                default:
                    System.out.println("\nOpção inválida!");
                    break;
    
            }
        }

        in.close();

    }
}
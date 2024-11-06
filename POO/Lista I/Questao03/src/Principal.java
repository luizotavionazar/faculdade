import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal {

    public void menu(Aluno aluno1) {
        System.out.println("\n==-==-==-==-==-==-==-==-==-==-==");
        System.out.println("        DADOS DO ALUNO");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==");
        System.out.println("    1 > Cadastrar Aluno");
        System.out.println("    2 > Atribuir notas");
        System.out.println("    3 > Status do aluno");
        System.out.println("    4 > Sair");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==\n");
    }

    public boolean cadastrarAlu(boolean cadastro, Aluno aluno1) {


        return cadastro;
    }

    public boolean cadastrarNota(boolean cadastro, Aluno aluno1) {

        return cadastro;
    }

    public float calcularMedia(float media, Aluno aluno1) {

        return media;
    }

    public void exibirStatus(Aluno aluno1) {
        Principal chamar= new Principal();
        float media= 0;

        media= chamar.calcularMedia(media, aluno1);

        if (media > 6) {
            System.out.println(aluno1.getNome()+" está aprovado!");
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner in= new Scanner(System.in);
        Aluno aluno1= new Aluno();
        Principal chamar= new Principal();
        boolean control= true, control1= true;
        int opcao= 0;
    
        Font fonteNegrito = new Font("SansSerif", 1, 14);
        Font fonteNormal = new Font("SansSerif", 0, 14);

        while (control) {
            chamar.menu(aluno1);

            do {
                System.out.print("Escolha a opção desejada: ");
                try {
                    opcao = in.nextInt();
                    control1 = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control1 = false;
                }
                
            } while (!control1);
    
            switch (opcao) {
                case 1:
                    System.out.println("\nA tela do jogo abriu em algum lugar, se não acha-la tecle 'Alt+Tab' para encontrar a janela!\n");
                    if (control1= chamar.cadastrarAlu(!control1, aluno1)) {
                        //control1= chamar.jogo(!control1, jogador1, jogador2);
                    }
                    break;

                case 2:
                    if (control1= chamar.cadastrarNota(!control1, aluno1)) {
                        //control1= chamar.jogo(!control1, jogador1, jogador2);
                    }
                    break;

                case 3:
                    chamar.exibirStatus(aluno1);
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

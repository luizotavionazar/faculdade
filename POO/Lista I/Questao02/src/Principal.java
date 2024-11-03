import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal {

    Font fonteNegrito = new Font("SansSerif", 1, 14);
    Font fonteItalico = new Font("SansSerif", 2, 14);

    public void menu(Jogador jogador1) {
        System.out.println("\n==-==-==-==-==-==-==-==-==-==-==");
        System.out.println("        ATAQUE MALUCO");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==");
        System.out.println("  1 > Iniciar jogo");
        System.out.println("  2 > Sair");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==\n");
    }
    
    public void exibirDetalhes(Jogador jogador1, Jogador jogador2) {

    }

    public Jogador ataque(Jogador jogador) {


        return jogador;
    }

    public boolean jogo(boolean jogo, Jogador jogador1, Jogador jogador2) {
        

        return jogo;
    }

    public boolean testePreenchimento(boolean control, String nomeJog1, String nomeJog2) {
        boolean control1=false;

        while (!control1) {

            if (nomeJog1.trim().isEmpty()&&nomeJog2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher o nome dos Jogadores",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                control1= true;
                control= false;
            }
    
            else if (nomeJog1.trim().isEmpty()&&!nomeJog2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher o nome do Jogador 1",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                control1= true;
                control= false;
            }
    
            else if (!nomeJog1.trim().isEmpty()&&nomeJog2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher o nome do Jogador 2",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                control1= true;
                control= false;
            }

            else {
                control1= true;
                control= true;
            }
        }

        return control;
    }

    public boolean cadastrarJog(boolean control, Jogador jogador1, Jogador jogador2) {
        Principal chamar= new Principal();
        boolean control1= true;

        JPanel telaCad= new JPanel();
        telaCad.setLayout(new BoxLayout(telaCad, BoxLayout.Y_AXIS));

        JLabel nome1= new JLabel("Nome do Jogador 1(*):");
        nome1.setFont(fonteNegrito);
        JTextField campoNome1 = new JTextField();

        JLabel nome2= new JLabel("Nome do Jogador 2(*):");
        nome2.setFont(fonteNegrito);
        JTextField campoNome2= new JTextField();

        JLabel orientacao= new JLabel("(*) Preenchimento obrigatório");
        orientacao.setFont(fonteItalico);

        telaCad.add(nome1);
        telaCad.add(campoNome1);
        telaCad.add(nome2);
        telaCad.add(campoNome2);
        telaCad.add(orientacao);

        JOptionPane.showMessageDialog(null, "O jogo será iniciado assim que preenchido o nome dos jogadores!\n\n", 
                        "Iniciando...", JOptionPane.INFORMATION_MESSAGE);
        while (!control) {
            int preenchimento= JOptionPane.showConfirmDialog(telaCad, telaCad, "Cadastro de Jogador",
                    JOptionPane.OK_CANCEL_OPTION);

            if (preenchimento == JOptionPane.OK_OPTION) {
                String nomeJog1= campoNome1.getText();
                String nomeJog2= campoNome2.getText();

                if (control1= chamar.testePreenchimento(!control1, nomeJog1, nomeJog2)) {
                    jogador1.setJogador(nomeJog1, 100, 100);
                    jogador2.setJogador(nomeJog2, 100, 100);
                    JOptionPane.showMessageDialog(null, "Jogadores cadastrados com sucesso.\n", 
                        "Cadastro realizado!", JOptionPane.INFORMATION_MESSAGE);
                    control = true;
                }
                
            }
                
            else {
                System.out.println("\nFoi cancelado o cadastro do Jogador!");
                control = true;
            }

        }

        return control;
    }
    
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        Jogador jogador1= new Jogador();
        Jogador jogador2= new Jogador();
        Principal chamar= new Principal();
        boolean control= true, control1= true;
        int opc= 0;

        while (control) {
            chamar.menu(jogador1);

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
                    control1= chamar.cadastrarJog(!control1, jogador1, jogador2);
                    control1= chamar.jogo(control1, jogador1, jogador2);
                    break;

                case 2:
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
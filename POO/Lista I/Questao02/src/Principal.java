import java.util.InputMismatchException;
import java.util.Random;
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
        System.out.println("  1 > Iniciar partida");
        if (jogador1.getNome() != null) {
            System.out.println("  2 > Detalhes da última partida");
        }
        System.out.println("  2 > Sair");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==\n");
    }
    
    public void exibirDetalhes(Jogador jogador1, Jogador jogador2) {
        JPanel telaStatus= new JPanel();
        telaStatus.setLayout(new BoxLayout(telaStatus, BoxLayout.Y_AXIS));

        JLabel linha1= new JLabel("Jogador 1: "+jogador1.getNome());
        linha1.setFont(fonteNegrito);
        JLabel linha2= new JLabel("Pontos: "+jogador1.getPontos());
        linha2.setFont(fonteItalico);
        JLabel linha3= new JLabel("Energia: "+jogador1.getEnergia());
        linha3.setFont(fonteItalico);
        JLabel espaco1= new JLabel(" ");
        JLabel linha4= new JLabel("Jogador 2: "+jogador2.getNome());
        linha4.setFont(fonteNegrito);
        JLabel linha5= new JLabel("Pontos: "+jogador2.getPontos());
        linha5.setFont(fonteItalico);
        JLabel linha6= new JLabel("Energia: "+jogador2.getEnergia());
        linha6.setFont(fonteItalico);
        JLabel espaco2= new JLabel(" ");

        telaStatus.add(linha1);
        telaStatus.add(linha2);
        telaStatus.add(linha3);
        telaStatus.add(espaco1);
        telaStatus.add(linha4);
        telaStatus.add(linha5);
        telaStatus.add(linha6);
        telaStatus.add(espaco2);

        JOptionPane.showMessageDialog(telaStatus, telaStatus, 
            "Placar atual", JOptionPane.INFORMATION_MESSAGE);

    }

    public boolean ataque(boolean ataca, int rodada, Jogador jogador1, Jogador jogador2) {
        Random random= new Random();
        int aleatorio1= random.nextInt(100);
        int aleatorio2= random.nextInt(100);
        int aleatorio3= random.nextInt(100);

        if (aleatorio1 < 50) { //50% de chance de acertar um ataque Fraco
            System.out.println("ataque fraco");

            if (rodada%2==1) {
                jogador2.setEnergia((jogador2.getEnergia())-10);
                jogador1.setPontos(jogador1.getPontos()+10);
            } else {
                jogador1.setEnergia(jogador1.getEnergia()-10);
                jogador2.setPontos(jogador2.getPontos()+10);
            }

        } else if (aleatorio1 < 70) { //30% de chance de acertar um ataque Forte
            System.out.println("ataque forte");

            if (rodada%2==1) {
                jogador2.setEnergia((jogador2.getEnergia())-20);
                jogador1.setPontos(jogador1.getPontos()+20);
            } else {
                jogador1.setEnergia(jogador1.getEnergia()-20);
                jogador2.setPontos(jogador2.getPontos()+20);
            }

        } else { //20% de chance de acetar um ataque Pancada
            System.out.println("ataque pancada");

            if (rodada%2==1) { //Jogador1= Atacante, Jogador 2= Oponente
                jogador2.setEnergia((jogador2.getEnergia())-25);
                jogador1.setPontos(jogador1.getPontos()+25);
                
                if (aleatorio2 < 40) { //Ataques Pancada tem 40% de chance de converter 2% da energia do oponente em dano extra
                    double hit_ex= 0.02*jogador2.getEnergia();
                    float hit_extra= (float) hit_ex;
                    jogador2.setEnergia(jogador2.getEnergia()-hit_extra);
                    System.out.println("causou "+hit_extra+" em dano extra, calculo: "+hit_ex);

                    if (aleatorio3 < 60) {//Além disso, o ataque Pancada tem 60% de chance de curar 10% da energia atual do atacante
                        double calculo= 0.10*jogador1.getEnergia();
                        float cura= (float) calculo;
                        jogador1.setEnergia(jogador1.getEnergia()+cura);
                        System.out.println("curou sua energia em "+cura+" calculo: "+calculo);

                    }
                }
            } else { //Jogador2= Atacante, Jogador 1= Oponente
                jogador1.setEnergia(jogador1.getEnergia()-25);
                jogador2.setPontos(jogador2.getPontos()+25);

                if (aleatorio2 < 40) {
                    double hit_ex= 0.03*jogador1.getEnergia();
                    float hit_extra= (float) hit_ex;
                    jogador1.setEnergia(jogador1.getEnergia()-hit_extra);

                    if (aleatorio3 < 10) {
                        double calculo= 0.05*jogador2.getEnergia();
                        float cura= (float) calculo;
                        jogador2.setEnergia(jogador2.getEnergia()+cura);

                    }
                }

            }
        }
        ataca= true;

        return ataca;
    }

    public boolean testeDesistencia(boolean desistiu, int rodada, Jogador jogador1, Jogador jogador2) {
        //O Atacante pode desistir apenas quando em desvantagem ao Oponente
        
        if (rodada%2 == 1) { //Jogador1= Atacante, Jogador 2= Oponente            
            
            if (jogador1.getEnergia()<jogador2.getEnergia()) {
                desistiu=true;
            } else {
                desistiu=false;
            }

        } else { //Jogador2= Atacante, Jogador 1= Oponente

            if (jogador2.getEnergia()<jogador1.getEnergia()) {
                desistiu=true;
            } else {
                desistiu=false;
            }
        }

        return desistiu;
    }

    public int telaJogo(int opc, int rodada, Jogador jogador1, Jogador jogador2) {
        String atacante= null;
        String oponente= null;
        boolean control= false;

        if (rodada%2 == 1) { //Define o atacante e o oponente da rodada
            atacante= jogador1.getNome();
            oponente= jogador2.getNome();
        } else {
            atacante= jogador2.getNome();
            oponente= jogador1.getNome();
        }

        JPanel telaRodada= new JPanel();
        telaRodada.setLayout(new BoxLayout(telaRodada, BoxLayout.Y_AXIS));

        JLabel linha1= new JLabel(rodada+"º Rodada");
        linha1.setFont(fonteNegrito);
        JLabel espaco1= new JLabel(" ");
        JLabel linha2= new JLabel("Atacante: "+atacante);
        linha2.setFont(fonteNegrito);
        JLabel linha3= new JLabel("Oponente: "+oponente);
        linha3.setFont(fonteNegrito);
        JLabel espaco2= new JLabel(" ");
        JLabel linha4= new JLabel("O que deseja fazer?");
        linha4.setFont(fonteItalico);
        JTextField opcao = new JTextField();
        JLabel linha5= new JLabel("1: Atacar");
        linha5.setFont(fonteItalico);
        JLabel linha6= new JLabel("2: Ver Placar");
        linha6.setFont(fonteItalico);
        JLabel linha7= new JLabel("3 ou 'Cancel': Pula a vez");
        linha7.setFont(fonteItalico);
        JLabel linha8= new JLabel("4: Desistir");
        linha8.setFont(fonteItalico);

        JLabel espaco3= new JLabel(" ");

        telaRodada.add(linha1);
        telaRodada.add(espaco1);
        telaRodada.add(linha2);
        telaRodada.add(linha3);
        telaRodada.add(espaco2);
        telaRodada.add(linha4);
        telaRodada.add(opcao);
        telaRodada.add(linha5);
        telaRodada.add(linha6);
        telaRodada.add(linha7);
        telaRodada.add(linha8);
        telaRodada.add(espaco3);
    
        while (!control) {
            int preenchimento= JOptionPane.showConfirmDialog(telaRodada, telaRodada, "ATAQUE MALUCO",
                    JOptionPane.OK_CANCEL_OPTION);

            if (preenchimento == JOptionPane.OK_OPTION) { //Atacante realizou uma ação
                
                try {
                    opc= Integer.parseInt(opcao.getText());

                    switch (opc) {
                        case 1:                        
                            break;
                        case 2:                    
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                "Erro: Opção inválida!", 
                                "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                            break;
                    }

                    control= true;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                        "Erro: Possiveis causas:\n            1- Campo em branco;\n            2- Informado caractere inválido (deve ser número).",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                }
            } else { //Atacante pulou a vez
                System.out.println("atacante pulou a vez");
                opc= 3;
                control= true;
            }
        }

        return opc;
    }

    public boolean jogo(boolean jogo, Jogador jogador1, Jogador jogador2) {
        Principal chamar= new Principal();
        int rodada= 0, opc= 0;
        boolean control= false;
        
        while (!control) { //Partida rolando
            boolean control1= false;
            rodada++;

            while (!control1) { //Rodada rolando

                opc= chamar.telaJogo(opc, rodada, jogador1, jogador2); //Necessário colocar a tela em uma função separada para que, sempre que ela seja chamada, a tela seja criada novamente(atualizada as variaveis)
                
                switch (opc) {
                    case 1:
                        control1= chamar.ataque(control1, rodada, jogador1, jogador2);
                        break;
    
                    case 2:
                        chamar.exibirDetalhes(jogador1, jogador2);
                        break;

                    case 3:
                        control1= true;
                        break;

                    case 4:
                        if (control= chamar.testeDesistencia(control, rodada, jogador1, jogador2)) {
                            control1= true; //Jogador desistiu
                        } else {
                            System.out.println("não da pra desistir nao, aguenta agora");
                        }
                        
                        break;
                }
            } 

            if (jogador1.getEnergia() <= 0|| //Determina o fim do jogo, verificando se um jogador esgotou suas energias
                jogador2.getEnergia() <= 0) {
                String vencedor= null;
                control= true;
                if (jogador1.getPontos() > jogador2.getPontos()) { //Define o vencedor a partir da quantidade de pontos
                    vencedor= jogador1.getNome();
                } else {
                    vencedor= jogador2.getNome();
                }

                System.out.println("O vencedor é: "+vencedor+", após "+rodada+" rodadas");
                //Adicionar chamada da tela de Fim de Jogo aqui
            }

        }

        return jogo;
    }

    public boolean testePreenchimento(boolean teste, String nomeJog1, String nomeJog2) {
        boolean control=false;

        while (!control) {

            if (nomeJog1.trim().isEmpty()&&nomeJog2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher o nome dos Jogadores",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                control= true;
                teste= false;
            } else if (nomeJog1.trim().isEmpty()&&!nomeJog2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher o nome do Jogador 1",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                control= true;
                teste= false;
            } else if (!nomeJog1.trim().isEmpty()&&nomeJog2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher o nome do Jogador 2",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                control= true;
                teste= false;
            } else {
                control= true;
                teste= true;
            }
        }

        return teste;
    }

    public boolean cadastrarJog(boolean cadastro, Jogador jogador1, Jogador jogador2) {
        Principal chamar= new Principal();
        boolean control= true;

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

        JOptionPane.showMessageDialog(null, "A partida será iniciada assim que preenchido o nome dos jogadores!\n\n", 
                        "ATAQUE MALUCO - Iniciando o jogo", JOptionPane.INFORMATION_MESSAGE);
        while (!cadastro) {
            int preenchimento= JOptionPane.showConfirmDialog(telaCad, telaCad, "Jogadores",
                    JOptionPane.OK_CANCEL_OPTION);

            if (preenchimento == JOptionPane.OK_OPTION) {
                String nomeJog1= campoNome1.getText();
                String nomeJog2= campoNome2.getText();

                if (control= chamar.testePreenchimento(!control, nomeJog1, nomeJog2)) {
                    jogador1.setJogador(nomeJog1, 0, 200);
                    jogador2.setJogador(nomeJog2, 0, 200);
                    JOptionPane.showMessageDialog(null, "Jogadores cadastrados com sucesso.\n", 
                        "Cadastro realizado!", JOptionPane.INFORMATION_MESSAGE);
                    cadastro = true;
                }
                
            } else {
                System.out.println("\nFoi cancelado o cadastro dos Jogadores, retornando ao menu principal!");
                cadastro = true;
            }
        }

        return cadastro;
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
                    System.out.println("\nA tela do jogo abriu em algum lugar, se não acha-la tecle 'Alt+Tab' que vai encontrar a sua janela!");
                    control1= chamar.cadastrarJog(!control1, jogador1, jogador2);
                    control1= chamar.jogo(!control1, jogador1, jogador2);
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
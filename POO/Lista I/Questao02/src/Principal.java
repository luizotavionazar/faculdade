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
        System.out.println("    ─▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄");
        System.out.println("    █░░░█░░░░░░░░░░▄▄░██░█");
        System.out.println("    █░▀▀█▀▀░▄▀░▄▀░░▀▀░▄▄░█");
        System.out.println("    █░░░▀░░░▄▄▄▄▄░░██░▀▀░█");
        System.out.println("    ─▀▄▄▄▄▄▀─────▀▄▄▄▄▄▄▀");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==");
        System.out.println("    1 > Iniciar partida");
        System.out.println("    2 > Tutorial");
        System.out.println("    3 > Sair");
        System.out.println("==-==-==-==-==-==-==-==-==-==-==\n");
    }
    
    public void exibirDetalhes(Jogador jogador1, Jogador jogador2, String atacante, String oponente) {
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

    public boolean ataque(boolean ataca, int rodada, Jogador jogador1, Jogador jogador2, String atacante, String oponente) {
        Random random= new Random();
        int aleatorio1= random.nextInt(100);
        int aleatorio2= random.nextInt(100);
        int aleatorio3= random.nextInt(100);
        String hit= null;
        double dano_ex= 0, calculo= 0;
        float dano= 0, dano_extra= 0, cura= 0;

        if (aleatorio1 < 50) { //50% de chance de acertar um ataque Fraco
            System.out.println("LOG:: Ataque foi Fraco");

            hit= "Fraco";
            dano= 10;

            if (rodada%2==1) {
                jogador2.setEnergia((jogador2.getEnergia())-10);
                jogador1.setPontos(jogador1.getPontos()+10);
            } else {
                jogador1.setEnergia(jogador1.getEnergia()-10);
                jogador2.setPontos(jogador2.getPontos()+10);
            }

        } else if (aleatorio1 < 80) { //30% de chance de acertar um ataque Forte
            System.out.println("LOG:: Ataque foi Forte");

            hit= "Forte";
            dano= 20;

            if (rodada%2==1) {
                jogador2.setEnergia((jogador2.getEnergia())-20);
                jogador1.setPontos(jogador1.getPontos()+20);
            } else {
                jogador1.setEnergia(jogador1.getEnergia()-20);
                jogador2.setPontos(jogador2.getPontos()+20);
            }

        } else { //20% de chance de acetar um ataque Pancada
            System.out.println("LOG:: Ataque foi Pancada");

            hit= "Pancada";
            dano= 25;

            if (rodada%2==1) { //Jogador1= Atacante, Jogador 2= Oponente
                jogador2.setEnergia((jogador2.getEnergia())-25);
                jogador1.setPontos(jogador1.getPontos()+25);
                
                if (aleatorio2 < 40) { //Ataques Pancada tem 40% de chance de converter 2% da energia atual do oponente em dano extra
                    dano_ex= 0.02*jogador2.getEnergia();
                    dano_extra= (float) dano_ex;
                    jogador2.setEnergia(jogador2.getEnergia()-dano_extra);
                    System.out.println("LOG:: Oponente recebeu "+dano_extra+" em dano extra");

                    if (aleatorio3 < 60) {//Além disso, o ataque Pancada tem 60% de chance de curar 10% da energia atual do atacante, a cura excedente se tranforma em vida máxima
                        calculo= 0.10*jogador1.getEnergia();
                        cura= (float) calculo;
                        jogador1.setEnergia(jogador1.getEnergia()+cura);
                        System.out.println("LOG:: Atacante curou sua energia em "+cura);

                    }
                }
            } else { //Jogador2= Atacante, Jogador 1= Oponente
                jogador1.setEnergia(jogador1.getEnergia()-25);
                jogador2.setPontos(jogador2.getPontos()+25);

                if (aleatorio2 < 40) {
                    dano_ex= 0.03*jogador1.getEnergia();
                    dano_extra= (float) dano_ex;
                    jogador1.setEnergia(jogador1.getEnergia()-dano_extra);

                    if (aleatorio3 < 10) {
                        calculo= 0.05*jogador2.getEnergia();
                        cura= (float) calculo;
                        jogador2.setEnergia(jogador2.getEnergia()+cura);

                    }
                }

            }
        }
        ataca= true;

        JPanel telaAtaque= new JPanel();
        telaAtaque.setLayout(new BoxLayout(telaAtaque, BoxLayout.Y_AXIS));

        JLabel linha1= new JLabel("FIM DA "+rodada+"ª RODADA");
        linha1.setFont(fonteNegrito);
        telaAtaque.add(linha1);

        JLabel espaco1= new JLabel(" ");        
        telaAtaque.add(espaco1);

        if (!hit.equals("Pancada")) {
            JLabel linha2= new JLabel(atacante+" acertou um golpe "+hit+" em "+oponente+"!!!");
            linha2.setFont(fonteNegrito);
            telaAtaque.add(linha2);
        } else {
            JLabel linha2= new JLabel(atacante+" acertou uma Pancada em "+oponente+"!!!");
            linha2.setFont(fonteNegrito);
            telaAtaque.add(linha2);
        }

        if (cura != 0) {
            JLabel linha3= new JLabel(">>> PANCADA REVIGORANTE");
            linha3.setFont(fonteItalico);
            telaAtaque.add(linha3);
            JLabel linha4= new JLabel("+"+(cura)+" de Energia ao Atacante!");
            linha4.setFont(fonteItalico);
            telaAtaque.add(linha4);
        }

        JLabel espaco2= new JLabel(" ");
        telaAtaque.add(espaco2);
        JLabel linha5= new JLabel(oponente+" recebeu "+(dano+dano_extra)+" de Dano");
        linha5.setFont(fonteNegrito);
        telaAtaque.add(linha5);

        if (dano_extra != 0) {
            JLabel linha6= new JLabel(">>> PANCADA CRÍTICA");
            linha6.setFont(fonteItalico);
            telaAtaque.add(linha6);
            JLabel linha7= new JLabel("+"+dano_extra+" de Dano no Oponente!");
            linha7.setFont(fonteItalico);
            telaAtaque.add(linha7);
        }

        JLabel espaco3= new JLabel(" ");
        telaAtaque.add(espaco3);

        JOptionPane.showMessageDialog(telaAtaque, telaAtaque, 
                        "LANÇADO O ATAQUE", JOptionPane.INFORMATION_MESSAGE);

        return ataca;
    }

    public boolean testeDesistencia(boolean desistiu, int rodada, Jogador jogador1, Jogador jogador2) {
        
        if (rodada%2 == 1) { //Jogador1= Atacante, Jogador 2= Oponente            
            
            if (jogador1.getEnergia()<jogador2.getEnergia()) { //O Atacante pode desistir apenas quando em desvantagem ao Oponente
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

    public int telaJogo(int opc, int rodada, Jogador jogador1, Jogador jogador2, String atacante, String oponente) {
        boolean control= false;

        JPanel telaRodada= new JPanel();
        telaRodada.setLayout(new BoxLayout(telaRodada, BoxLayout.Y_AXIS));

        JLabel linha1= new JLabel(rodada+"º Rodada");
        linha1.setFont(fonteNegrito);
        telaRodada.add(linha1);
        JLabel espaco1= new JLabel(" ");
        telaRodada.add(espaco1);
        JLabel linha2= new JLabel("Atacante: "+atacante);
        linha2.setFont(fonteNegrito);
        telaRodada.add(linha2);
        JLabel linha3= new JLabel("Oponente: "+oponente);
        linha3.setFont(fonteNegrito);
        telaRodada.add(linha3);
        JLabel espaco2= new JLabel(" ");
        telaRodada.add(espaco2);
        JLabel linha4= new JLabel("O que deseja fazer?");
        linha4.setFont(fonteItalico);
        telaRodada.add(linha4);
        JTextField opcao = new JTextField();
        telaRodada.add(opcao);
        JLabel linha5= new JLabel("1: Atacar");
        linha5.setFont(fonteItalico);
        telaRodada.add(linha5);
        JLabel linha6= new JLabel("2: Ver Placar");
        linha6.setFont(fonteItalico);
        telaRodada.add(linha6);
        JLabel linha7= new JLabel("3 ou 'Cancel': Pula a vez");
        linha7.setFont(fonteItalico);
        telaRodada.add(linha7);
        JLabel linha8= new JLabel("4: Desistir");
        linha8.setFont(fonteItalico);
        telaRodada.add(linha8);
        JLabel espaco3= new JLabel(" ");
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
                            System.out.println("LOG:: Selecionada opção inválida");
                            break;
                    }

                    control= true;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                        "Erro: Possiveis causas:\n            1- Campo em branco;\n            2- Informado caractere inválido (deve ser número).",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                    System.out.println("LOG:: Campo em branco ou preenchido incorretamente");
                }
            } else { //Atacante pulou a vez
                opc= 3;
                control= true;
            }
        }

        return opc;
    }

    public boolean jogo(boolean jogo, Jogador jogador1, Jogador jogador2) {
        Principal chamar= new Principal();
        int rodada= 0, opc= 0;
        boolean control= false, desistiu= false;
        String atacante= null, oponente= null;
        
        System.out.println("LOG:: Partida iniciada");
        while (!control) { //Partida rolando
            boolean control1= false;
            rodada++;

            if (rodada%2==1) { //Define o Atacante e Oponente da rodada
                atacante= jogador1.getNome();
                oponente= jogador2.getNome();
            } else {
                atacante= jogador2.getNome();
                oponente= jogador1.getNome();
            }

            System.out.println("LOG:: Inicio da "+rodada+"ª rodada - Atacante: "+atacante+" Oponente: "+oponente);
            while (!control1) { //Rodada rolando

                opc= chamar.telaJogo(opc, rodada, jogador1, jogador2,atacante, oponente); //Necessário colocar a tela em uma função separada para que, sempre que ela seja chamada, a tela seja criada novamente(atualizada as variaveis)
                
                switch (opc) {
                    case 1:
                        control1= chamar.ataque(control1, rodada, jogador1, jogador2,atacante,oponente);
                        break;
    
                    case 2:
                        chamar.exibirDetalhes(jogador1, jogador2,atacante,oponente);
                        System.out.println("LOG:: Exibido o placar");
                        break;

                    case 3:
                        control1= true;
                        System.out.println("LOG:: Atacante pulou a vez");
                        break;

                    case 4:
                        if (desistiu= chamar.testeDesistencia(control, rodada, jogador1, jogador2)) {
                            control1= true;
                            System.out.println("LOG:: Atacante desistiu");
                        } else {
                            System.out.println("LOG:: Atacante tentou desistir");
                        }
                        
                        break;
                }
            }
            System.out.println("LOG:: Fim da "+rodada+"ª rodada"); 

            if (jogador1.getEnergia() <= 0|| //Determina o fim do jogo, verificando se um jogador esgotou suas energias ou desistiu
                jogador2.getEnergia() <= 0||
                desistiu) {
                String vencedor= null, perdedor= null;
                float pontosV= 0, pontosP= 0, energiaV= 0, energiaP= 0;
                control= true;

                if (jogador1.getPontos() > jogador2.getPontos()) { //Define o Vencedor e Perdedor
                    vencedor= jogador1.getNome();
                    perdedor= jogador2.getNome();
                    pontosV= jogador1.getPontos();
                    pontosP= jogador2.getPontos();
                    energiaV= jogador1.getEnergia();
                    energiaP= jogador2.getEnergia();
                } else {
                    vencedor= jogador2.getNome();
                    perdedor= jogador1.getNome();
                    pontosV= jogador2.getPontos();
                    pontosP= jogador1.getPontos();
                    energiaV= jogador2.getEnergia();
                    energiaP= jogador1.getEnergia();
                }

                System.out.println("LOG:: Fim de Jogo. O vencedor foi: "+vencedor+", após "+rodada+" rodadas");
                JPanel telaFim= new JPanel();
                telaFim.setLayout(new BoxLayout(telaFim, BoxLayout.Y_AXIS));

                JLabel linha1= new JLabel("FIM DE JOGO");
                linha1.setFont(fonteNegrito);
                telaFim.add(linha1);
                JLabel linha2= new JLabel("Total de rodadas: "+rodada);
                linha2.setFont(fonteItalico);
                telaFim.add(linha2);
                JLabel espaco1= new JLabel(" ");
                telaFim.add(espaco1);
                JLabel linha3= new JLabel(vencedor+" Ganhou a partida com "+pontosV+" pontos e "+energiaV+" de Energia");
                linha3.setFont(fonteItalico);
                telaFim.add(linha3);
                JLabel espaco2= new JLabel(" ");
                telaFim.add(espaco2);

                if (desistiu) {
                    JLabel linha4= new JLabel(perdedor+" desistiu com "+pontosP+" pontos e "+energiaP+" de Energia");
                    linha4.setFont(fonteItalico);
                    telaFim.add(linha4);
                } else {
                    JLabel linha4= new JLabel(perdedor+" ficou sem Energia aos "+pontosP+" pontos");
                    linha4.setFont(fonteItalico);
                    telaFim.add(linha4);
                }
                
                
                
                JLabel espaco3= new JLabel(" ");
                telaFim.add(espaco3);
                
                JOptionPane.showMessageDialog(telaFim, telaFim, "Partida encerrada", JOptionPane.INFORMATION_MESSAGE);

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
        boolean control= false;

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
        while (!control) {
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
                    System.out.println("LOG:: Jogadores cadastrados");
                    cadastro = true;
                }
                
            } else {
                System.out.println("\nFoi cancelado o cadastro dos Jogadores, retornando ao menu principal!");
                cadastro = false;
                control= true;
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
        int opcao= 0;

        Font fonteNegrito = new Font("SansSerif", 1, 14);
        Font fonteNormal = new Font("SansSerif", 0, 14);

        while (control) {
            chamar.menu(jogador1);

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
                    if (control1= chamar.cadastrarJog(!control1, jogador1, jogador2)) {
                        control1= chamar.jogo(!control1, jogador1, jogador2);
                    }
                    break;

                case 2:
                    System.out.println("\nA tela do Tutorial abriu em algum lugar, se não acha-la tecle 'Alt+Tab' para encontrar a janela!\n");
                    JPanel telaTutorial= new JPanel();
                    telaTutorial.setLayout(new BoxLayout(telaTutorial, BoxLayout.Y_AXIS));

                    JLabel linha1= new JLabel("ATAQUE MALUCO - MANUAL");
                    linha1.setFont(fonteNegrito);
                    telaTutorial.add(linha1);
                    JLabel espaco1= new JLabel(" ");
                    telaTutorial.add(espaco1);
                    JLabel linha2= new JLabel(" - O jogo é uma disputa de ataques entre 2 jogadores, preencha seus nomes para iniciar a partida;");
                    linha2.setFont(fonteNormal);
                    telaTutorial.add(linha2);
                    JLabel espaco2= new JLabel(" ");
                    telaTutorial.add(espaco2);
                    JLabel linha3= new JLabel(" - Os jogadores iniciam a partir com 0 Pontos e 200 de Energia, perde quem zerar a sua energia primeiro;");
                    linha3.setFont(fonteNormal);
                    telaTutorial.add(linha3);
                    JLabel espaco3= new JLabel(" ");
                    telaTutorial.add(espaco3);
                    JLabel linha4= new JLabel(" - O atacante pode Pular a vez ou Desistir da partida, para desistir, o Atacante deve ter menos Energia que o Oponente;");
                    linha4.setFont(fonteNormal);
                    telaTutorial.add(linha4);
                    JLabel espaco4= new JLabel(" ");
                    telaTutorial.add(espaco4);
                    JLabel linha5= new JLabel(" - É realizado 1 ataque por rodada e cada ataque diminui a Energia do Oponente de acordo com o Dano recebido;");
                    linha5.setFont(fonteNormal);
                    telaTutorial.add(linha5);
                    JLabel espaco5= new JLabel(" ");
                    telaTutorial.add(espaco5);
                    JLabel linha6= new JLabel(" - Existem 3 tipos de ataques, Fraco (Causa 10 de Dano), Forte (Causa 15 de Dano) e Pancada (Causa 25 de Dano);");
                    linha6.setFont(fonteNormal);
                    telaTutorial.add(linha6);
                    JLabel espaco6= new JLabel(" ");
                    telaTutorial.add(espaco6);
                    JLabel linha7= new JLabel(" - Ao realizar um ataque, ele tem 50% de chance ser Fraco, 30% de ser Forte e 20% de ser uma Pancada;");
                    linha7.setFont(fonteNormal);
                    telaTutorial.add(linha7);
                    JLabel espaco7= new JLabel(" ");
                    telaTutorial.add(espaco7);
                    JLabel linha8= new JLabel(" - Ataques Pancadas podem causar 2 efeitos especiais, sendo eles a Pancada Crítica e a Pancada Revigorante;");
                    linha8.setFont(fonteNormal);
                    telaTutorial.add(linha8);
                    JLabel espaco8= new JLabel(" ");
                    telaTutorial.add(espaco8);
                    JLabel linha9= new JLabel(" - A Pancada Crítica transforma 2% da Energia atual do Oponente em Dano Extra para si mesmo;");
                    linha9.setFont(fonteNormal);
                    telaTutorial.add(linha9);
                    JLabel espaco9= new JLabel(" ");
                    telaTutorial.add(espaco9);
                    JLabel linha10= new JLabel(" - A Pancada Revigorante restaura 10% da Energia atual do Atacante, a cura excedente se transforma em Energia máxima;");
                    linha10.setFont(fonteNormal);
                    telaTutorial.add(linha10);
                    JLabel espaco10= new JLabel(" ");
                    telaTutorial.add(espaco10);
                    JLabel linha11= new JLabel(" - Caso o Oponente receba uma Pancada, ele tem 40% de chance de sofrer uma Pancada Crítica;");
                    linha11.setFont(fonteNormal);
                    telaTutorial.add(linha11);
                    JLabel espaco11= new JLabel(" ");
                    telaTutorial.add(espaco11);
                    JLabel linha12= new JLabel(" - Caso o Oponente receba uma Pancada Crítica, o Atacante tem 60% de chance de receber uma Pancada Revigorante;");
                    linha12.setFont(fonteNormal);
                    telaTutorial.add(linha12);
                    JLabel espaco12= new JLabel(" ");
                    telaTutorial.add(espaco12);
                    
                    JOptionPane.showMessageDialog(telaTutorial, telaTutorial, "Tutorial", JOptionPane.INFORMATION_MESSAGE);

                    break;

                case 3:
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
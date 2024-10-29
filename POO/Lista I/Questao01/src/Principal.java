import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*; //Para criar as janelas
import java.awt.Font; //Para alterar as fontes

public class Principal {
    public String descProduto = null;
    public float precoProduto = 0;
    public float quantProduto = 0;

    // JPanel - Cria a janela;
    // setLayout - Organiza os campos da janela, sendo: Y_AXIS= Vertical, X_AXIS= Horizontal;
    // JLabel - Cria o campo de saída;
    // JTextField - Cria o campo de entrada;
    // Em "JTextField()", caso o 'setLayout' seja 'X', o valor dentro de '()' define o tamanho(visual) do campo;
    // Documentação da classe 'JOptionPane': https://brunoagt.wordpress.com/2011/03/28/javax-swing-joptionpane-conhecendo-e-utilizando-a-classe-joptionpane/

    // Como usar a classe 'Font':
    // Sintaxe: Font("nomeDaFonte", estiloDaFonte, tamanhoDaFonte);
    // Exemplos de fontes: "Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput"
    // Estilos de fonte: 0= Regular, padrão
    //                   1= Negrito
    //                   2= Italico
    //                   3= Negrito e Italico
    // Para utilizar a fonte na janela: "nomeDaLabel.setFont(nomeDaFonteCriada)"
    //                              ou: "nomeDaLabel.setFont(new Font("nomeDaFonte", estiloDaFonte, tamanhoDaFonte))"
    // Fonte padrão das label: [family=Dialog,name=Dialog,style=bold,size=12]

    Font fonteNegrito = new Font("SansSerif", 1, 14);
    Font fonteItalico = new Font("SansSerif", 2, 14);

    public void menu(Produto produto) {
        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("         MENU PRODUTO");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("  1 > Cadastrar");

        if (produto.getDescricao()!=null) {
            System.out.println("  2 > Informações");
            System.out.println("  3 > Calcular Valor Total");
        }

        System.out.println("  4 > Sair");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n");
    }

    public Produto cadastrarProduto(Produto produto) {
        boolean control = false;

        JPanel telaCad = new JPanel();
        telaCad.setLayout(new BoxLayout(telaCad, BoxLayout.Y_AXIS));

        JLabel descricao = new JLabel("Descrição(*):");
        descricao.setFont(fonteNegrito);
        JTextField campoDescricao = new JTextField();

        JLabel preco = new JLabel("Preço(*):");
        preco.setFont(fonteNegrito);
        JTextField campoPreco = new JTextField();

        JLabel quantidade = new JLabel("Quantidade(*):");
        quantidade.setFont(fonteNegrito);
        JTextField campoQuantidade = new JTextField();

        JLabel orientacao = new JLabel("(*) Preenchimento obrigatório");
        orientacao.setFont(fonteItalico);

        // Adiciona os campos na janela, na ordem da inserção
        telaCad.add(descricao);
        telaCad.add(campoDescricao);
        telaCad.add(preco);
        telaCad.add(campoPreco);
        telaCad.add(quantidade);
        telaCad.add(campoQuantidade);
        telaCad.add(orientacao);

        while (!control) {
            int preenchimento = JOptionPane.showConfirmDialog(null, telaCad, "Cadastro Produto",
                    JOptionPane.OK_CANCEL_OPTION);

            if (preenchimento == JOptionPane.OK_OPTION) { // Grava os dados preenchidos

                descProduto = campoDescricao.getText();
                if (descProduto.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher a Descrição do Produto",
                            "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                    continue; // Necessário continuar para reiniciar o looping e não validar o Preço e Quantidade caso vazios
                }

                try {
                    precoProduto = Float.parseFloat(campoPreco.getText());
                    quantProduto = Float.parseFloat(campoQuantidade.getText());
                    produto.setProduto(descProduto, precoProduto, quantProduto);
                    System.out.println("\nProduto cadastrado com sucesso!");
                    control = true;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Erro: Preço e/ou Quantidade preenchido(s) incorretamente!\n          *Possiveis causas:\n            1- Campo em branco;\n            2- Informado caractere inválido (deve ser número).",
                            "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                }
            }

            else {
                System.out.println("\nFoi cancelado o cadastro do Produto");
                control = true;
            }

        }

        return produto;
    }

    public void exibirDetalhes(Produto produto) {

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("   Produto: "+produto.getDescricao());
        System.out.println("     Preço: R$"+produto.getPreco());
        System.out.println("Quantidade: "+produto.getQuantidade());

    }

    public void calcularTotal(Produto produto) {
        float media= produto.getPreco()*produto.getQuantidade();

        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("      Valor total: R$"+media);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Principal chamar = new Principal();
        Produto produto = new Produto();
        boolean control = true, control1= true;
        int opc = 0;

        while (control) {
            chamar.menu(produto);
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
                    produto = chamar.cadastrarProduto(produto);
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
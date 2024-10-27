import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

public class Principal {

    public void menu() {
        System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("         MENU PRODUTO");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("  1 > Cadastrar");
        System.out.println("  2 > Informações");
        System.out.println("  3 > Calcular Valor Total");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n");
    }

    public Produto cadastrarProduto(Produto produto) {
        String descProduto = null;
        float precoProduto = 0;
        float quantProduto = 0;
        boolean control = false;

        // JPanel - Cria a janela;
        // setLayout - Organiza os campos da janela, sendo: Y_AXIS= Vertical, X_AXIS= Horizontal;
        // JLapel - Cria o campo de saída;
        // JTextField - Cria o campo de entrada;
        // Em "JTextField()", caso o 'setLayout' seja 'X', o valor dentro de '()' define o tamanho(visual) do campo;
        // Documentação da classe 'JOptionPane': https://brunoagt.wordpress.com/2011/03/28/javax-swing-joptionpane-conhecendo-e-utilizando-a-classe-joptionpane/

        JPanel telaCad = new JPanel();
        telaCad.setLayout(new BoxLayout(telaCad, BoxLayout.Y_AXIS));

        JLabel descricao = new JLabel("Descrição(*):");
        JTextField campoDescricao = new JTextField();

        JLabel preco = new JLabel("Preço(*):");
        JTextField campoPreco = new JTextField();

        JLabel quantidade = new JLabel("Quantidade(*):");
        JTextField campoQuantidade = new JTextField();

        JLabel orientacao = new JLabel("(*) Preenchimento obrigatório");

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
                    System.out.println("Produto cadastrado com sucesso!");
                    control = true;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Erro: Preço e/ou Quantidade preenchido(s) incorretamente!\n          *Possiveis causas:\n            1- Campo em branco;\n            2- Informado caractere inválido (deve ser número).",
                            "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                }
            }

            else {
                System.out.println("Foi cancelado o cadastro do Produto");
                control = true;
            }

        }

        return produto;
    }

    public void exibirDetalhes() {

    }

    public void calcularTotal() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Principal chamar = new Principal();
        Produto produto = new Produto();
        boolean control = true;
        int opc = 0;

        chamar.menu();

        do {
            System.out.print("Escolha a opção desejada: ");
            try {
                opc = in.nextInt();
                System.out.println("\n");
                control = true;
            } catch (InputMismatchException e) {
                System.out.println("\nInforme um valor válido!\n");
                in.next();
                control = false;
            }
        } while (!control);

        switch (opc) {
            case 1:
                produto = chamar.cadastrarProduto(produto);
                break;

            case 2:

                break;

            case 3:

                break;

            default:
                break;

        }

        in.close();
    }
}
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

        // JPanel - Cria a tela
        // JLapel - Cria o campo
        // JTextField - Cria o preenchimento do campo
        // setLayout - Organiza a ordem dos campos da tela, Y= Vertical, X= Horizontal
        // Em "JTextField()", caso o setLayout seja X, o valor dentro de '()'' define o
        // tamanho(visual) do campo

        JPanel tela = new JPanel();
        tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));

        JLabel descricao = new JLabel("Descrição(*):");
        JTextField campoDescricao = new JTextField();

        JLabel preco = new JLabel("Preço(*):");
        JTextField campoPreco = new JTextField();

        JLabel quantidade = new JLabel("Quantidade(*):");
        JTextField campoQuantidade = new JTextField();

        JLabel orientacao = new JLabel("(*) Preenchimento obrigatório");

        // Adiciona os campos na tela
        tela.add(descricao);
        tela.add(campoDescricao);
        tela.add(preco);
        tela.add(campoPreco);
        tela.add(quantidade);
        tela.add(campoQuantidade);
        tela.add(orientacao);

        while (!control) {
            int preenchimento = JOptionPane.showConfirmDialog(null, tela, "Cadastro Produto",
                    JOptionPane.OK_CANCEL_OPTION);

            if (preenchimento == JOptionPane.OK_OPTION) { // Grava os dados preenchidos

                descProduto = campoDescricao.getText();
                if (descProduto.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: Obrigatório preencher a Descrição do Produto",
                            "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                    continue; // Necessário continuar para reiniciar o looping e não valir Preço e Quantidade
                              // caso vazio
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
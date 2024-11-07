import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal {

    public void menu(Aluno aluno1) {
        int opc= 2;
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
        Scanner in= new Scanner(System.in);

        System.out.print("\nInforme o nome do aluno: ");
        aluno1.setNome(in.nextLine());

        do {
            System.out.print("Informe a idade do aluno: ");
            try {
                aluno1.setIdade(in.nextInt());
                cadastro= true;
            } catch (InputMismatchException e) {
                System.out.println("\nInforme um valor válido!\n");
                in.next();
                cadastro = false;
            }
        } while (!cadastro);

        return cadastro;
    }

    public boolean cadastrarNota(boolean cadastro, Aluno aluno1) {
        Scanner in= new Scanner(System.in);

        do {
            try {
                System.out.print("\nInsira a Nota 1: ");
                aluno1.setNota1(in.nextInt());
                System.out.print("Insira a Nota 2: ");
                aluno1.setNota2(in.nextInt());
                cadastro= true;
            } catch (InputMismatchException e) {
                System.out.println("\nInforme um valor válido!\n");
                in.next();
                cadastro = false;
            }
        } while (!cadastro);

        return cadastro;
    }

    public float calcularMedia(float media, Aluno aluno1) {
        media= (aluno1.getNota1()+aluno1.getNota2())/2;
        return media;
    }

    public void exibirStatus(Aluno aluno1) {
        Principal chamar= new Principal();
        float media= 0;

        media= chamar.calcularMedia(media, aluno1);

        if (media > 6) {
            System.out.println("\n"+aluno1.getNome()+" está aprovado!");
        } else {
            System.out.println("\n"+aluno1.getNome()+" está reprovado!");
        }
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        Aluno aluno1= new Aluno();
        Principal chamar= new Principal();
        boolean control= true, control1= true;
        int opcao= 0;
        aluno1.setNota1(-1); //Para atender a condição do Menu

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
                    if (control1= chamar.cadastrarAlu(!control1, aluno1)) {
                        System.out.println("\nAluno cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    if (aluno1.getNome() == null) {
                        System.out.println("\nNecessário cadastrar o aluno primeiro!");
                    } else {
                        if (control1= chamar.cadastrarNota(!control1, aluno1)) {
                            System.out.println("\nNotas atribuidas com sucesso!");
                        }
                    }
                    System.out.println(aluno1.getNota1());
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

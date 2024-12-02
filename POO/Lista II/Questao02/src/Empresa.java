import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Empresa {
    public void adicionarFunc(ArrayList<Funcionario> funcionarios) {
        Scanner in= new Scanner(System.in);

        String nome, cargo;
        double salario;
        boolean control;
        
        System.out.print("\nNome do funcionário...: ");
        nome= in.nextLine();
        System.out.print("Cargo....: ");
        cargo= in.nextLine();

        do {
            System.out.print("Salário......: ");
                try {
                    salario= in.nextInt();
                    funcionarios.add(new Funcionario(nome, cargo, salario));
                    control= true;
                } catch (InputMismatchException e) {
                    System.out.println("\nInforme um valor válido!\n");
                    in.next();
                    control= false;
                }
            } while (!control);
    }

    public void exibirFunc(ArrayList<Funcionario> funcionarios, Iterator<Funcionario> iterat) {
        iterat= funcionarios.iterator();

        while (iterat.hasNext()) {
            Funcionario funcionario= iterat.next();
            System.out.println("\n"+funcionario);
        }

    }

    public void calcularMediaSal(ArrayList<Funcionario> funcionarios, Iterator<Funcionario> iterat) {
        iterat= funcionarios.iterator();
        double media= 0;
        int qtdFunc= 0;

        while (iterat.hasNext()) {
            qtdFunc++;
            Funcionario funcionario= iterat.next();
            double salFunc= funcionario.getSalario();
            media= media+salFunc;
        }

        media= media/qtdFunc;
        System.out.println("\nMedia salarial da empresa: "+media);

    }

    public void buscarFunc(ArrayList<Funcionario> funcionarios, Iterator<Funcionario> iterat) {
        Scanner in= new Scanner(System.in);
        iterat= funcionarios.iterator();

        System.out.print("\n> Pesquisa de Funcionário por cargo");
        
        System.out.print("\nInforme o cargo do mesmo: ");
        String cargo= in.nextLine();
        cargo= cargo.toLowerCase().replace(" ", ""); //Converte a pesquisa para minuscula e remove os espaços

        while (iterat.hasNext()) {
            Funcionario funcionario = iterat.next(); // Obtém o próximo funcionario da lista
            String cargoFunc= funcionario.getCargo().toLowerCase().replace(" ", ""); //Converte o cargo para minuscula e remove os espaços
            if (cargoFunc.equals(cargo)) { // Verifica o cargo
                System.out.print("\nFuncionário encontrado: "+funcionario+"\n");
                }
            }
    }
    
}
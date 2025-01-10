import ProgramaPessoas.Adolescente;
import ProgramaPessoas.Adulto;
import ProgramaPessoas.Crianca;
import ProgramaPessoas.Pessoa;

public class Vida {
    public static void main(String[] args) throws Exception {
    Pessoa brasileiro = new Pessoa(0, "Natalina");
    // brasileiro.comer(); não pode ser chamado porque é protected

    Crianca enzo = new Crianca(3, "Enzo", "123456789");
    enzo.comer();

    Adulto maria = new Adulto(50, "Maria", "123.456.789-10");
    maria.comer();
    System.out.println(maria.toString());

    Adolescente patricio = new Adolescente(15, "Patricio", "222.222.222-22", maria);
    patricio.comer();
    System.out.println(patricio.toString());

    brasileiro = maria;
    maria = patricio;

    }
}
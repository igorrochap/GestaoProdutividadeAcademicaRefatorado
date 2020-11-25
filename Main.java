import classes.Aluno;
import classes.Colaborador;
import classes.ProducaoAcademica;
import classes.Professor;
import classes.Projeto;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE PRODUTIVIDADE ACADÊMICA");
        
        Colaborador colab = new Aluno("Jorge", "jorge@jorge", "Graduação");
        Colaborador colab1 = new Aluno("Mario", "jorge@jorge", "Graduação");
        Colaborador colab2 = new Aluno("Silvio", "jorge@jorge", "Graduação");
        Colaborador colab3 = new Professor("Marcos", "email");
        
        ProducaoAcademica prod = new ProducaoAcademica();

        //prod.add(colab);
        //prod.add(colab1);
        //prod.add(colab2);
        float valor = 100;
        Projeto prj = new Projeto("titulo", "12/12/2012", "01/01/2013", "Caixa economica", valor, "Torre", "Teste", colab3);
        
        prj.alocaColaborador(colab);
    }
}

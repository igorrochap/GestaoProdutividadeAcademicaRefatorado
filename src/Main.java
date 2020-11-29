package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.classes.Aluno;
import src.classes.Colaborador;
import src.classes.ProducaoAcademica;
import src.classes.Professor;
import src.classes.Projeto;

public class Main {
    public static int startOptions(){
        Scanner op = new Scanner(System.in);

        System.out.println("**************OPÇÕES:*************");
        System.out.println("*  [1] Adicionar colaborador     *");
        System.out.println("*  [2] Criar projeto             *");
        System.out.println("*  [3] Criar produção acadêmica  *");
        System.out.println("*  [4] Editar projeto            *");
        System.out.println("**********************************");
        System.out.print("Selecione a opção desejada: ");
        int opt = op.nextInt();

        return opt;
    }

    public static void newColaborador(){
        Scanner op = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        Scanner mail = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("*     [1] Aluno                      *");
        System.out.println("*     [2] Professor                  *");
        System.out.println("*     [3] Pesquisador                *");
        System.out.println("**************************************");
        System.out.print("Selecione a opção desejada: ");
        int opt = op.nextInt();

        System.out.print("Informe o nome do colaborador: ");
        String nome = n.nextLine();
        System.out.println();
        System.out.print("Informe o email do colaborador: ");
        String email = mail.nextLine();
        System.out.println();
        
        if(opt == 1){
            Scanner s = new Scanner(System.in);
            
            System.out.println("*************GRAU DO ALUNO************");
            System.out.println("*         Graduacao                  *");
            System.out.println("*         Mestrado                   *");
            System.out.println("*         Doutorado                  *");
            System.out.println("**************************************");
            System.out.print("Digite uma das opções acima: ");
            String tipo = s.nextLine();


            Colaborador c = new Aluno(nome, email, tipo);
            //System.out.print(Colaborador.getQtd());
        }
        
        
        //s.close();
    }

    public static void main(String[] args) {
        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("* SISTEMA DE PRODUTIVIDADE ACADÊMICA *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        System.out.println();

        int option = startOptions();
        //System.out.println(option);
        switch(option){
            case 1:
                System.out.println();
                newColaborador();
                option = startOptions();
        }
    }
}

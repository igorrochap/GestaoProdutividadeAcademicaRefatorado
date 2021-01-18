package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.classes.*;

public class Main {
    public static int startOptions(){
        Scanner op = new Scanner(System.in); // scanner da opção
        int opt = -1;

        System.out.println("**************OPÇÕES:*************");
        System.out.println("*  [1] Adicionar colaborador     *");
        System.out.println("*  [2] Criar projeto             *");
        System.out.println("*  [3] Criar produção acadêmica  *");
        System.out.println("*  [4] Editar projeto            *");
        System.out.println("*  [5] Consultar por colaborador *");
        System.out.println("*  [6] Consultar por projeto     *");
        System.out.println("*  [7] Relatório                 *");
        System.out.println("*  [0] Encerrar programa         *");
        System.out.println("**********************************");
        System.out.print("Selecione a opção desejada: ");

        try{
            opt = op.nextInt();
        }
        catch(InputMismatchException error){
            System.err.println("Por favor, selecione uma das opções válidas.");
            opt = startOptions();
        }

        return opt;
    }

    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>(); 
        ArrayList<Professor> professores = new ArrayList<Professor>(); 
        ArrayList<Projeto> projetos = new ArrayList<Projeto>(); 
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        ArrayList<Publicacao> producoes = new ArrayList<Publicacao>();
        

        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("* SISTEMA DE PRODUTIVIDADE ACADÊMICA *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        System.out.println();

        int option = startOptions();

        while(option != 0){
            switch(option){
                case 1:
                    System.out.println();
                    Colaborador.newColaborador(professores, colaboradores, alunos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 2:
                    System.out.println();
                    Projeto.newProjeto(professores, projetos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 3:
                    ArrayList<Colaborador> autores = new ArrayList<Colaborador>();
                    ProducaoAcademica.newProdAcad(colaboradores, autores, professores, alunos, producoes);
                    System.out.println();
                    option = startOptions();
                    break;
                case 4:
                    System.out.println();
                    Projeto.editProjeto(projetos, colaboradores, producoes);
                    System.out.println();
                    option = startOptions();
                    break;
                case 5:
                    System.out.println();
                    Colaborador.queryColaborador(colaboradores);
                    System.out.println();
                    option = startOptions();
                    break;
                case 6:
                    System.out.println();
                    Projeto.queryProjeto(projetos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 7:
                    System.out.println();
                    Relatorio relatorio = new Relatorio();
                    relatorio.relatorio();
                    System.out.println();
                    option = startOptions();
                    break;
            }
        }
    }
}

package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.classes.Aluno;
import src.classes.Colaborador;
import src.classes.ProducaoAcademica;
import src.classes.Professor;
import src.classes.Pesquisador;
import src.classes.Projeto;

public class Main {
    public static int startOptions(){
        Scanner op = new Scanner(System.in);

        System.out.println("**************OPÇÕES:*************");
        System.out.println("*  [1] Adicionar colaborador     *");
        System.out.println("*  [2] Criar projeto             *");
        System.out.println("*  [3] Criar produção acadêmica  *");
        System.out.println("*  [4] Editar projeto            *");
        System.out.println("*  [0] Encerrar programa         *");
        System.out.println("**********************************");
        System.out.print("Selecione a opção desejada: ");
        int opt = op.nextInt();

        return opt;
    }

    public static void newColaborador(ArrayList<Professor> professores){
        Scanner op = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        Scanner e = new Scanner(System.in);

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
        String email = e.nextLine();
        System.out.println();
        
        if(opt == 1){ // caso seja um aluno
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
        else if(opt == 2){ // caso seja um professor
            Colaborador c = new Professor(nome, email);

            Professor prof = (Professor) c;
            professores.add(prof);
            //System.out.print(Colaborador.getQtd());
        }
        else if(opt == 3){ // caso seja um pesquisador
            Colaborador c = new Pesquisador(nome, email);
            //System.out.print(Colaborador.getQtd());
        }

        //op.close();
        //n.close();
        //e.close();
    }

    public static void newProjeto(ArrayList<Professor> professores){
        int i = 0;
        Scanner t = new Scanner(System.in);
        Scanner di = new Scanner(System.in);
        Scanner dt = new Scanner(System.in);
        Scanner af = new Scanner(System.in);
        Scanner vf = new Scanner(System.in);
        Scanner o = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        Scanner pr = new Scanner(System.in);

        System.out.print("Informe o titulo do projeto: ");
        String titulo = t.nextLine();

        System.out.println();
        
        System.out.print("Informe a data de inicio do projeto: ");
        String dataInicio = di.nextLine();
        
        System.out.println();

        System.out.print("Informe a data de término do projeto: ");
        String dataTermino = dt.nextLine();

        System.out.println();

        System.out.print("Informe a agência financiadora do projeto: ");
        String agenciaFinanciadora = af.nextLine();

        System.out.println();

        System.out.print("Informe o valor financiado: ");
        float valorFinanciado = vf.nextFloat();

        System.out.println();

        System.out.print("Informe o objetivo do projeto: ");
        String objetivo = o.nextLine();

        System.out.println();

        System.out.print("Informe a descrição do projeto: ");
        String descricao = d.nextLine();

        System.out.println();
        System.out.println("****************************************");
        System.out.println("*                                      *");
        for(i = 0; i < professores.size(); i++){
            System.out.println("*            [" + i +"] "+ professores.get(i).getNome() +"                    *");
        }
        System.out.println("*                                      *");
        System.out.println("****************************************");
        System.out.print("Selecione o professor que será inicialmente alocado no projeto: ");
        int prof = pr.nextInt();

        Colaborador professor = professores.get(prof);

        Projeto prj = new Projeto(titulo, dataInicio, dataTermino, agenciaFinanciadora, valorFinanciado, objetivo, descricao, professor);
    }

    public static void main(String[] args) {
        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("* SISTEMA DE PRODUTIVIDADE ACADÊMICA *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        System.out.println();

        ArrayList<Professor> professores = new ArrayList<Professor>();
        int option = startOptions();

        while(option != 0){ // enquanto não for dado o comando de parar o programa
            switch(option){
                case 1: // adiciona colaborador
                    System.out.println();
                    newColaborador(professores);
                    option = startOptions();
                    break;
                case 2: // adiciona projeto
                    System.out.println();
                    newProjeto(professores);
                    option = startOptions();
                    break;
            }
        }
    }
}

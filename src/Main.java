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
        Scanner op = new Scanner(System.in); // scanner da opção

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

    public static void newColaborador(ArrayList<Professor> professores, ArrayList<Colaborador> colaboradores){
        Scanner op = new Scanner(System.in); //scanner da opcao
        Scanner n = new Scanner(System.in); // scanner do nome do colaborador
        Scanner e = new Scanner(System.in); //scanner do email do colaborador

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
            Scanner s = new Scanner(System.in); // scanner do grau do aluno
            
            System.out.println("*************GRAU DO ALUNO************");
            System.out.println("*         Graduacao                  *");
            System.out.println("*         Mestrado                   *");
            System.out.println("*         Doutorado                  *");
            System.out.println("**************************************");
            System.out.print("Digite uma das opções acima: ");
            String tipo = s.nextLine();


            Colaborador c = new Aluno(nome, email, tipo);
            colaboradores.add(c);
            //System.out.print(Colaborador.getQtd());
        }
        else if(opt == 2){ // caso seja um professor
            Colaborador c = new Professor(nome, email);
            colaboradores.add(c);

            Professor prof = (Professor) c;
            professores.add(prof);
            //System.out.print(Colaborador.getQtd());
        }
        else if(opt == 3){ // caso seja um pesquisador
            Colaborador c = new Pesquisador(nome, email);
            colaboradores.add(c);
            //System.out.print(Colaborador.getQtd());
        }
    }

    public static void newProjeto(ArrayList<Professor> professores, ArrayList<Projeto> projetos){
        int i = 0;
        Scanner t = new Scanner(System.in); // scanner do titulo
        Scanner di = new Scanner(System.in); // scanner da data de inicio
        Scanner dt = new Scanner(System.in); // scanner da data de termino
        Scanner af = new Scanner(System.in); // scanner da data financiadora
        Scanner vf = new Scanner(System.in); // scanner do valor financiado
        Scanner o = new Scanner(System.in); // scanner do objetivo
        Scanner d = new Scanner(System.in); // scanner da descricao
        Scanner pr = new Scanner(System.in); // scanner do primeiro professor alocado ao projeto

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

        if(professores.size() > 0){
            System.out.println("****************************************");
            System.out.println("*                                      *");
            for(i = 0; i < professores.size(); i++){
                System.out.println("[" + i +"] "+ professores.get(i).getNome());
            }
            System.out.println("*                                      *");
            System.out.println("****************************************");
            System.out.print("Selecione o professor que será inicialmente alocado no projeto: ");
            int prof = pr.nextInt();
    
            Colaborador professor = professores.get(prof);
            
            Projeto prj = new Projeto(titulo, dataInicio, dataTermino, agenciaFinanciadora, valorFinanciado, objetivo, descricao, professor);
            projetos.add(prj);
        }
        else{
            System.out.println("Não existem professores cadastrados no sistema!");
        }

    }

    public static void newProdAcad(ArrayList<Colaborador> colaboradores, ArrayList<Colaborador> autores){
        Scanner op = new Scanner(System.in); //scanner da opção
        String s;

        System.out.println("**********************");
        System.out.println("*  [1] Publicação    *");
        System.out.println("*  [2] Orientação    *");
        System.out.println("**********************");
        System.out.print("Selecione a opção desejada: ");
        int opt = op.nextInt();

        if(opt == 1){
            Scanner a = new Scanner(System.in); // scanner dos autores da publicação
            Scanner sn = new Scanner(System.in);
            

            do{
                System.out.println("Informe os autores da publicação: ");
                for(int i = 0; i < colaboradores.size(); i++){
                    System.out.println("["+ i +"] " + colaboradores.get(i).getNome());
                }
                int au = a.nextInt();
                Colaborador c = colaboradores.get(au);
                autores.add(c);

                System.out.println("Existem mais autores da publicação? [S/N]: ");
                s = sn.nextLine();
            }while(s.equalsIgnoreCase("S"));
        }
    }

    public static void editProjeto(ArrayList<Projeto> projetos, ArrayList<Colaborador> colaboradores){
        Scanner p = new Scanner(System.in); //scanner do projeto
        Scanner op = new Scanner(System.in);//scanner da opcao
        int i = 0;

        System.out.println("**************************************");
        for(i = 0; i < projetos.size(); i++){
            System.out.println("["+ i +"] " + projetos.get(i).getTitulo());
        }
        System.out.println("*************************************");
        System.out.print("Selecione o projeto a ser editado: ");
        int pr = p.nextInt();

        Projeto projeto = projetos.get(pr);

        System.out.println();
        System.out.println("****************************");
        System.out.println("*  [1] Alocar participante *");
        System.out.println("*  [2] Alterar status      *");
        System.out.println("****************************");
        int opt = op.nextInt();

        if(opt == 1) {
            Scanner c = new Scanner(System.in);
            System.out.println("**************************************");
            for(i = 0; i < colaboradores.size(); i++){
                System.out.println("["+i+"] " + colaboradores.get(i).getNome());
            }
            System.out.println("**************************************");
            System.out.print("Selecione o colaborador que deseja alocar no projeto: ");
            int col = c.nextInt();

            Colaborador colaborador = colaboradores.get(col);

            projeto.alocaColaborador(colaborador);
        }
        else if(opt == 2){
            projeto.changeStatus();
        }
    }

    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>(); //colaboradores cadastrados no sistema
        ArrayList<Professor> professores = new ArrayList<Professor>(); // professores cadastrados no sistema
        ArrayList<Projeto> projetos = new ArrayList<Projeto>(); // projetos cadastrados no sistema
        

        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("* SISTEMA DE PRODUTIVIDADE ACADÊMICA *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        System.out.println();

        int option = startOptions();

        while(option != 0){ // enquanto não for dado o comando de parar o programa
            switch(option){
                case 1: // adiciona colaborador
                    System.out.println();
                    newColaborador(professores, colaboradores);
                    option = startOptions();
                    break;
                case 2: // adiciona projeto
                    System.out.println();
                    newProjeto(professores, projetos);
                    option = startOptions();
                    break;
                case 3:
                    ArrayList<Colaborador> autores = new ArrayList<Colaborador>(); // autores de uma publicacao
                    newProdAcad(colaboradores, autores);
                    break;
                case 4:
                    System.out.println();
                    editProjeto(projetos, colaboradores);
                    break;
            }
        }
    }
}

package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.classes.Aluno;
import src.classes.Colaborador;
import src.classes.ProducaoAcademica;
import src.classes.Professor;
import src.classes.Pesquisador;
import src.classes.Projeto;
import src.classes.Publicacao;
import src.classes.Relatorio;

public class Main {
    public static void msgErroDados(){
        System.err.println("Dados informados incorretamente! Por favor, informe os dados corretamente.");
    }

    public static void msgErroOpcoes(){
        System.err.println("Por favor, selecione uma das opções válidas.");
    }

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
            msgErroOpcoes();
            opt = startOptions();
        }

        return opt; // opção selecionada
    }

    public static int alunoGrau(){
        int grau = 0;
        Scanner s = new Scanner(System.in); // scanner do grau do aluno

        System.out.println("*************GRAU DO ALUNO************");
        System.out.println("*         [1] Graduacao              *");
        System.out.println("*         [2] Mestrado               *");
        System.out.println("*         [3] Doutorado              *");
        System.out.println("**************************************");
        System.out.print("Digite o grau do aluno: ");

        try{
            grau = s.nextInt();
        }
        catch(InputMismatchException error){
            msgErroOpcoes();
            grau = alunoGrau();
        }

        return grau;
    }

    public static void newColaborador(ArrayList<Professor> professores, ArrayList<Colaborador> colaboradores,  ArrayList<Aluno> alunos){
        Scanner op = new Scanner(System.in); //scanner da opcao
        Scanner n = new Scanner(System.in); // scanner do nome do colaborador
        Scanner e = new Scanner(System.in); //scanner do email do colaborador
        int opt = -1;

        System.out.println("**************************************");
        System.out.println("*     [1] Aluno                      *");
        System.out.println("*     [2] Professor                  *");
        System.out.println("*     [3] Pesquisador                *");
        System.out.println("**************************************");
        System.out.print("Selecione a opção desejada: ");

        try{
            opt = op.nextInt();

            System.out.print("Informe o nome do colaborador: ");
            String nome = n.nextLine();
            System.out.print("Informe o email do colaborador: ");
            String email = e.nextLine();
            System.out.println();
        
            if(opt == 1){ // caso seja um aluno
                String tipo = "";
                int grau = 0;

                grau = alunoGrau();

                do{
                    if(grau == 1)
                        tipo = "Graduacao";
                    else if(grau == 2)
                        tipo = "Mestrado";
                    else if(grau == 3)
                        tipo = "Doutorado";
                    else{
                        msgErroOpcoes();
                        grau = alunoGrau();
                    }
                }while(grau == -1);

                Colaborador c = new Aluno(nome, email, tipo);
                colaboradores.add(c);
        
                Aluno al = (Aluno) c;
                alunos.add(al);
            }
            else if(opt == 2){ // caso seja um professor
                Colaborador c = new Professor(nome, email);
                colaboradores.add(c);

                Professor prof = (Professor) c;
                professores.add(prof);
            }
            else if(opt == 3){ // caso seja um pesquisador
                Colaborador c = new Pesquisador(nome, email);
                colaboradores.add(c);
            }    
        }
        catch(InputMismatchException error){
            msgErroOpcoes();
            newColaborador(professores, colaboradores, alunos);
        }
    }

    public static void newProjeto(ArrayList<Professor> professores, ArrayList<Projeto> projetos){
        try{
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
                for(i = 0; i < professores.size(); i++){
                    System.out.println("[" + i +"] "+ professores.get(i).getNome());
                }
                System.out.print("Selecione o professor que será inicialmente alocado no projeto: ");
                int prof = pr.nextInt();
        
                Colaborador professor = professores.get(prof);
                
                Projeto prj = new Projeto(titulo, dataInicio, dataTermino, agenciaFinanciadora, valorFinanciado, objetivo, descricao, professor);
                projetos.add(prj);
            }
            else{ // o projeto deve ter pelo menos 1 professor alocado
                System.out.println("Não existem professores cadastrados no sistema! O projeto deve ter pelo menos 1 professor alocado!");
            }
        }
        catch(Exception ex){
            msgErroDados();
            newProjeto(professores, projetos);
        }
    }

    public static void newProdAcad(ArrayList<Colaborador> colaboradores, ArrayList<Colaborador> autores, 
                                   ArrayList<Professor> professores,  ArrayList<Aluno> alunos){
        try{
            Scanner op = new Scanner(System.in); //scanner da opção
            String s; // opção de continuar adicionando autores
    
            System.out.println("**********************");
            System.out.println("*  [1] Publicação    *");
            System.out.println("*  [2] Orientação    *");
            System.out.println("**********************");
            System.out.print("Selecione a opção desejada: ");
            int opt = op.nextInt();
    
            if(opt == 1){
                Scanner a = new Scanner(System.in); // scanner dos autores da publicação
                Scanner sn = new Scanner(System.in); // scanner sim/nao
                Scanner t = new Scanner(System.in); // scanner do titulo
                Scanner con = new Scanner(System.in); // scanner da conferencia
                Scanner ap = new Scanner(System.in); // scanner do ano de apresentação da publicação
                
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
    
                System.out.print("Informe o titulo da publicação: ");
                String titulo = t.nextLine();
    
                System.out.println();
                
                System.out.print("Informe o nome da conferência em que a publicação foi apresentada: ");
                String nomeConferencia = con.nextLine();
                
                System.out.println();
    
                System.out.print("Informe em que ano a publicação foi apresentada: ");
                int anoPublicacao = ap.nextInt();
    
    
                ProducaoAcademica prod = new Publicacao(titulo, nomeConferencia, anoPublicacao, autores);
                
                Publicacao publicacao = (Publicacao) prod;
                for(int i = 0; i < autores.size(); i++){
                    autores.get(i).addPublicacao(publicacao);
    
                    autores.remove(i);
                }
            }
            else if(opt == 2){
                Scanner al = new Scanner(System.in); // scanner do aluno a ser orientado
                Scanner p = new Scanner(System.in); // scanner do professor que irá orientar
    
                for(int i = 0; i < alunos.size(); i++){
                    System.out.println("    [" + i + "] " + alunos.get(i).getNome());
                }
    
                System.out.print("Selecione o aluno a ser orientado: ");
                int alu = al.nextInt();
    
                Aluno aluno = alunos.get(alu);
    
                for(int i = 0; i < professores.size(); i++){
                    System.out.println("    [" + i + "] " + professores.get(i).getNome());
                }
    
                System.out.print("Selecione o professor que irá orientar: ");
                int prof = p.nextInt();
    
                Professor professor = professores.get(prof);
    
                ProducaoAcademica orientacao = new ProducaoAcademica();
    
                orientacao.orientacao(professor, aluno); // adicionando a orientação
            }
        }
        catch(Exception error){
            msgErroDados();
            newProdAcad(colaboradores, autores, professores, alunos);
        }
    }

    public static void editProjeto(ArrayList<Projeto> projetos, ArrayList<Colaborador> colaboradores){
        try{
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
            System.out.print("Selecione a opção desejada: ");
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
        catch(Exception error){
            msgErroDados();
            editProjeto(projetos, colaboradores);
        }
    }

    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>(); //colaboradores cadastrados no sistema
        ArrayList<Professor> professores = new ArrayList<Professor>(); // professores cadastrados no sistema
        ArrayList<Projeto> projetos = new ArrayList<Projeto>(); // projetos cadastrados no sistema
        ArrayList<Aluno> alunos = new ArrayList<Aluno>(); // projetos cadastrados no sistema
        

        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("* SISTEMA DE PRODUTIVIDADE ACADÊMICA *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        System.out.println();

        int option = startOptions();

        while(option != 0){ // enquanto não for dado o comando de parar o programa
            switch(option){
                case 1: // adiciona novo colaborador
                    System.out.println();
                    newColaborador(professores, colaboradores, alunos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 2: // adiciona novo projeto
                    System.out.println();
                    newProjeto(professores, projetos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 3: // adiciona nova produção academica
                    ArrayList<Colaborador> autores = new ArrayList<Colaborador>(); // autores de uma publicacao
                    newProdAcad(colaboradores, autores, professores, alunos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 4: // edita projeto existente
                    System.out.println();
                    editProjeto(projetos, colaboradores);
                    System.out.println();
                    option = startOptions();
                    break;
                case 5: // consulta por colaborador
                    System.out.println();
                    Colaborador.queryColaborador(colaboradores);
                    System.out.println();
                    option = startOptions();
                    break;
                case 6: // consulta por projeto
                    System.out.println();
                    Projeto.queryProjeto(projetos);
                    System.out.println();
                    option = startOptions();
                    break;
                case 7: // relatorio do laboratório
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

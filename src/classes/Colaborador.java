package src.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Colaborador{
    private String nome;
    private String email;
    private static int qtdColaboradores = 0;
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
    private ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();

    public Colaborador(String nome, String email){
        this.nome = nome;
        this.email = email;
        qtdColaboradores++;
    }

    private static void msgErroOpcoes(){
        System.err.println("Por favor, selecione uma das opções válidas.");
    }

    private static int alunoGrau(){
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
        catch(InputMismatchException ex){
            msgErroOpcoes();
            grau = alunoGrau();
        }

        return grau;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public static int getQtd(){
        return qtdColaboradores;
    }

    public void addProjeto(Projeto projeto){
        this.projetos.add(projeto);
    }
    
    public void addPublicacao(Publicacao publicacao){
        this.publicacoes.add(publicacao);
    }

    public ArrayList<Projeto> getProjetos(){
        return this.projetos;
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
                System.out.println("Aluno adicionado no sistema!");
            }
            else if(opt == 2){ // caso seja um professor
                Colaborador c = new Professor(nome, email);
                colaboradores.add(c);
                
                Professor prof = (Professor) c;
                professores.add(prof);
                
                System.out.println("Professor adicionado no sistema!");
            }
            else if(opt == 3){ // caso seja um pesquisador
                Colaborador c = new Pesquisador(nome, email);
                colaboradores.add(c);

                System.out.println("Pesquisador adicionado no sistema!");
            }    
        }
        catch(InputMismatchException ex){
            //msgErroOpcoes();
            newColaborador(professores, colaboradores, alunos);
        }
    }

    public ArrayList<Projeto> sortDescendingProj(){
        Collections.sort(this.projetos, new Comparator<Projeto>(){
            public int compare(Projeto projeto1, Projeto projeto2){
                return - projeto1.getDataTermino().compareTo(projeto2.getDataTermino()); // fazendo a ordenação ser decrescente
            }
        });

        return this.projetos;
    }

    public ArrayList<Publicacao> sortDescendingPubli(){
        Collections.sort(this.publicacoes, new Comparator<Publicacao>(){
            public int compare(Publicacao publicacao1, Publicacao publicacao2){
                Integer a1 = publicacao1.getAnoPublicacao(); // argumento 1
                Integer a2 = publicacao2.getAnoPublicacao(); // argumento 2
                return - a1.compareTo(a2); // retornando em ordem descrescente
            }
        });

        return this.publicacoes;
    }

    public void query(){
        System.out.println("Nome do colaborador: " + this.nome);
        System.out.println("Email do colaborador: " + this.email);
        ArrayList<Projeto> projetosSort = new ArrayList<Projeto>();
        ArrayList<Publicacao> publiSort = new ArrayList<Publicacao>();

        projetosSort = sortDescendingProj();
        for(int i = 0; i < this.projetos.size(); i++){
            System.out.println("  Projeto " + (i+1) + ": " + projetosSort.get(i).getTitulo());
        }

        publiSort = sortDescendingPubli();
        for(int i = 0; i < this.publicacoes.size(); i ++){
            System.out.println("  Produção " + (i + 1) + ": " + publiSort.get(i).getTitulo());
        }
    }

    public static void queryColaborador(ArrayList<Colaborador> colaboradores){
        try{
            int col;
            Scanner c = new Scanner(System.in); //scanner do colaborador selecionado

            if(colaboradores.size() > 0){
                for(int i = 0; i < colaboradores.size(); i++){
                    System.out.println("["  +i +"] " + colaboradores.get(i).getNome());
                }
    
                System.out.print("Selecione o colaborador que deseja consultar os dados: ");

                col = c.nextInt();
                Colaborador colaborador = colaboradores.get(col);
                System.out.println();
                colaborador.query();
            
            }
            else {
                System.out.println("Não existem colaboradores cadastrados no sistema!");
            }
        }
        catch(Exception error){
            msgErroOpcoes();
            queryColaborador(colaboradores);
        }
    }
}
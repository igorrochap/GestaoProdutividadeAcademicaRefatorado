package src.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.classes.state.*;

public class Projeto {
    private String titulo;
    private String dataInicio, dataTermino;
    private String agenciaFinanciadora;
    private float valorFinanciado;
    private String objetivo;
    private String descricao;
    private ArrayList<Colaborador> participantes = new ArrayList<Colaborador>();
    private Colaborador professor;
    private State elaboracaoState;
    private State andamentoState;
    private State concluidoState;
    private ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
    private State status;
    private static int qtdProjetos = 0; // quantidade total de projetos
    private static int qtdProjetosElaboracao = 0; // quantidade de projetos em elaboração
    private static int qtdProjetosAndamento = 0; // quantidade de projetos em andamento
    private static int qtdProjetosConcluidos = 0; // quantidade de projetos concluidos

    

    public Projeto(
        String titulo,
        String dataInicio, 
        String dataTermino,
        String agenciaFinanciadora,
        float valorFinanciado,
        String objetivo,
        String descricao,
        Colaborador professor
    )
    {
        elaboracaoState = new ElaboracaoState(this);
        andamentoState = new AndamentoState(this);
        concluidoState = new ConcluidoState(this);
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.professor = professor;
        this.participantes.add(this.professor);
        this.professor.addProjeto(this);
        this.status = elaboracaoState;
        qtdProjetos++;
        qtdProjetosElaboracao++;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getDataTermino(){
        return this.dataTermino;
    }

    public ArrayList<Publicacao> getPublicacoes(){
        return this.publicacoes;
    }

    public static int getQtdProjetos(){
        return qtdProjetos;
    }
    
    public static int getQtdProjetosElaboracao(){
        return qtdProjetosElaboracao;
    }
    
    public static int getQtdProjetosAndamento(){
        return qtdProjetosAndamento;
    }
    
    public static int getQtdProjetosConcluidos(){
        return qtdProjetosConcluidos;
    }

    public static void setQtdProjetosElaboracao(int value){
        qtdProjetosElaboracao = value;
    }

    public static void setQtdProjetosAndamento(int value){
        qtdProjetosAndamento = value;
    }

    public static void setQtdProjetosConcluidos(int value){
        qtdProjetosConcluidos = value;
    }

    public State getElaboracaoState(){
        return this.elaboracaoState;
    }

    public State getAndamentoState(){
        return this.andamentoState;
    }

    public State getConcluidoState(){
        return this.concluidoState;
    }
    
    public void alocaColaborador(Colaborador colaborador){
        // if(this.status.equalsIgnoreCase("Em elaboracao")){ 
        //     if(colaborador instanceof Aluno){
        //         Aluno aluno = (Aluno) colaborador;
        //         if(aluno.tipo.equalsIgnoreCase("Graduacao")){  
        //             if(aluno.getQtdProjetos() == 2) 
        //                 System.out.println("O aluno já tem dois projetos atribuidos!");
        //             else{
        //                 this.participantes.add(colaborador);
        //                 colaborador.addProjeto(this); 
        //                 aluno.addQtdProjeto();
        //                 System.out.println("Aluno adicionado");
        //             }
        //         }
        //         else{
        //             this.participantes.add(colaborador); 
        //             colaborador.addProjeto(this);
        //         }
        //     }
        // }
        // else{
        //     System.out.println("O projeto não aceita mais novas alocações de colaboradores!");
        // }
    }

    public void addPublicacao(Publicacao publicacao){
        if(this.status == andamentoState) 
            this.publicacoes.add(publicacao);
        else
            System.out.println("Publicação não pode ser associada, pois o projeto está " + this.status);
    }

    public ArrayList<Integer> alterarQuantidade(int value1, int value2){
        ArrayList<Integer> returns = new ArrayList<Integer>();
        
        value1--;
        value2 ++;

        returns.add(value1); 
        returns.add(value2);

        return returns;
    }

    public void changeStatus(){
        status.changeStatus();
    }

    public void setStatus(State status){
        this.status = status;
    }

    public static void editProjeto(ArrayList<Projeto> projetos, ArrayList<Colaborador> colaboradores, ArrayList<Publicacao> producoes){
        try{
            Scanner p = new Scanner(System.in); //scanner do projeto
            Scanner op = new Scanner(System.in);//scanner da opcao
            Scanner pro = new Scanner(System.in);
            int i = 0;
            
            if(projetos.size() > 0){
                System.out.println("**************************************");
                for(i = 0; i < projetos.size(); i++){
                    System.out.println("["+ i +"] " + projetos.get(i).getTitulo());
                }
                System.out.println("*************************************");
                System.out.print("Selecione o projeto a ser editado: ");
                int pr = p.nextInt();
        
                Projeto projeto = projetos.get(pr);
        
                System.out.println();
                System.out.println("*****************************");
                System.out.println("*  [1] Alocar participante  *");
                System.out.println("*  [2] Alterar status       *");
                System.out.println("*  [3] Adicionar publicacao *");
                System.out.println("*****************************");
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
                else if(opt == 3){
                    System.out.println("**************************************");
                    for(i = 0; i < producoes.size(); i++){
                        System.out.println("["+i+"] " + producoes.get(i).getTitulo());
                    }
                    System.out.println("**************************************");
                    System.out.print("Selecione a produção que deseja alocar no projeto: ");
                    
                    int prod = pro.nextInt();

                    Publicacao publicacao = producoes.get(prod);
                    
                    projeto.addPublicacao(publicacao);
                }
            }
            else {
                System.out.println("Não existem projetos cadastrados no sistema!");
            }
        }
        catch(Exception error){
            System.err.println("Por favor, selecione uma das opções válidas.");
            editProjeto(projetos, colaboradores, producoes);
        }
    }

    public ArrayList<Publicacao> publicacoesSort(){
        Collections.sort(this.publicacoes, new Comparator<Publicacao>(){
            public int compare(Publicacao publicacao1, Publicacao publicacao2){
                Integer arg1 = publicacao1.getAnoPublicacao(); 
                Integer arg2 = publicacao2.getAnoPublicacao();
                return - arg1.compareTo(arg2); // retornando em ordem descrescente
            }
        });

        return this.publicacoes;
    }

    public void query(){
        ArrayList<Publicacao> publicacoesSort = publicacoesSort();

        System.out.println("Titulo do projeto: "  + this.titulo);
        System.out.println("Data de inicio do projeto: "  + this.dataInicio);
        System.out.println("Data de termino do projeto: "  + this.dataTermino);
        System.out.println("Agencia financiadora do projeto: "  + this.agenciaFinanciadora);
        System.out.println("Valor financiado: "  + this.valorFinanciado);
        System.out.println("Objetivo do projeto: "  + this.objetivo);
        System.out.println("Descrição do projeto: "  + this.descricao);
        System.out.println("Status: "  + this.status);
        
        System.out.println("Participantes do projeto: ");
        for(int i = 0; i < participantes.size(); i++){
            System.out.println("    #" + (i + 1) + " " + participantes.get(i).getNome());
        }

    
        System.out.println("Produções acadêmicas do projeto: ");
        for(int i = 0; i < publicacoes.size(); i++){
            System.out.println("    #" + (i + 1) + " " + publicacoesSort.get(i).getTitulo());
        }
    }

    public static void queryProjeto(ArrayList<Projeto> projetos){
        Scanner p = new Scanner(System.in);

        for(int i = 0; i < projetos.size(); i++){
            System.out.println("[" + i +"] " + projetos.get(i).getTitulo());
        }

        System.out.print("Selecione o projeto que deseja consultar os dados: ");
        
        try{
            int proj = p.nextInt();
    
            Projeto projeto = projetos.get(proj);
            System.out.println();
            projeto.query();
        }
        catch(InputMismatchException error){
            System.err.println("Por favor, selecione uma das opções válidas.");
            queryProjeto(projetos);
        }
    }
}

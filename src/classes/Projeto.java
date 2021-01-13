package src.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Projeto {
    private String titulo;
    private String dataInicio, dataTermino;
    private String agenciaFinanciadora;
    private float valorFinanciado;
    private String objetivo;
    private String descricao;
    private ArrayList<Colaborador> participantes = new ArrayList<Colaborador>();
    private Colaborador professor;
    private String status;
    private ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
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
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        // this.participantes = participantes;
        this.status = "Em elaboracao";
        this.professor = professor;
        this.participantes.add(this.professor);
        this.professor.addProjeto(this);
        qtdProjetos++;
        qtdProjetosElaboracao++;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getDataTermino(){
        return this.dataTermino;
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
    
    public void alocaColaborador(Colaborador colaborador){
        if(this.status.equalsIgnoreCase("Em elaboracao")){ // se o status do projeto for "em elaboração"
            if(colaborador instanceof Aluno){ // caso o colaborador seja um aluno
                Aluno aluno = (Aluno) colaborador;
                if(aluno.tipo.equalsIgnoreCase("Graduacao")){  // se o aluno é um aluno de graduação
                    if(aluno.getQtdProjetos() == 2) // se o aluno já tem 2 projetos atribuidos
                        System.out.println("O aluno já tem dois projetos atribuidos!");
                    else{
                        this.participantes.add(colaborador);
                        colaborador.addProjeto(this); 
                        aluno.addQtdProjeto(); // adiciona +1 no contador de projetos do aluno
                        System.out.println("Aluno adicionado");
                    }
                }
                else{
                    this.participantes.add(colaborador); 
                    colaborador.addProjeto(this);
                }
            }
        }
        else{
            System.out.println("O projeto não aceita mais novas alocações de colaboradores!");
        }
    }

    public void addPublicacao(Publicacao publicacao){
        if(this.status.equalsIgnoreCase("Em andamento")) // se o projeto estiver em andamento
            this.publicacoes.add(publicacao);
        else
            System.out.println("Publicação não pode ser associada, pois o projeto está " + this.status);
    }

    public void changeStatus(){
        if(this.status.equalsIgnoreCase("Em elaboracao")){
            this.status = "Em andamento";
            System.out.println("O projeto agora está em andamento!");
            qtdProjetosElaboracao--;
            qtdProjetosAndamento++; 
        }
        else if(this.status.equalsIgnoreCase("Em andamento")){
            if(this.publicacoes.size() > 0){ // caso existam publicações associadas ao projeto
                this.status = "Concluido";
                System.out.println("Projeto concluido!");
                qtdProjetosAndamento--; 
                qtdProjetosConcluidos++; 
            } 
            else{
                System.out.println("Para alterar o status para 'Concluido', o projeto deve ter publicações associadas");
            }
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

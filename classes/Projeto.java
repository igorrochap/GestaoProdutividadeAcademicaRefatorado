package classes;

import java.util.ArrayList;

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
        this.status = "Em elaboração";
        this.professor = professor;
    }

    public void alocaColaborador(Colaborador colaborador){
        if(this.status.equalsIgnoreCase("Em elaboração")){ // se o status do projeto for "em elaboração"
            if(colaborador instanceof Aluno){ // caso o colaborador seja um aluno
                Aluno aluno = (Aluno) colaborador;
                if(aluno.tipo == "Graduação"){ ; // se o aluno é um aluno de graduação
                    if(aluno.getProjetos() == 2) // se o aluno já tem 2 projetos atribuidos
                        System.out.println("O aluno já tem dois projetos atribuidos!");
                    else{
                        this.participantes.add(colaborador);
                        aluno.addProjeto(); // adiciona +1 no contador de projetos do aluno
                    }
                }
                else
                    this.participantes.add(colaborador); 
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
        if(this.status.equalsIgnoreCase("Em elaboração"))
            this.status = "Em andamento";
        else if(this.status.equalsIgnoreCase("Em andamento")){
            if(this.publicacoes.size() != 0) // caso não existam publicações associadas ao projeto
                this.status = "Concluido";
            else{
                System.out.println("Para alterar o status para 'Concluido', o projeto deve ter publicações associadas");
            }
        }
    }
}

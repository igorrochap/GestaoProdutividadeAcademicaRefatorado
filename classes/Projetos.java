package classes;

public class Projetos {
    private String titulo;
    private String dataInicio, dataTermino;
    private String agenciaFinanciadora;
    private float valorFinanciado;
    private String objetivo;
    private String descricao;
    private String participantes[];
    private String status;

    public Projetos(
        String titulo,
        String dataInicio, 
        String dataTermino,
        String agenciaFinanciadora,
        float valorFinanciado,
        String objetivo,
        String descricao,
        String participantes[]
    ){
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.status = "Em elaboração";
    }
}

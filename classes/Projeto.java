package classes;

import java.util.ArrayList;

public class Projeto {
    private String titulo;
    private String dataInicio, dataTermino;
    private String agenciaFinanciadora;
    private float valorFinanciado;
    private String objetivo;
    private String descricao;
    private ArrayList participantes = new ArrayList<Colaborador>();
    private String status;

    public Projeto(
        String titulo,
        String dataInicio, 
        String dataTermino,
        String agenciaFinanciadora,
        float valorFinanciado,
        String objetivo,
        String descricao
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
    }

    public void changeStatus(){
        if(this.status.equalsIgnoreCase("Em elaboração"))
            this.status = "Em andamento";
        else if(this.status.equalsIgnoreCase("Em andamento"))
            this.status = "Concluido";
    }
}

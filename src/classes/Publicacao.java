package src.classes;

import java.util.ArrayList;

public class Publicacao extends ProducaoAcademica{
    private ArrayList<Colaborador> autores = new ArrayList<Colaborador>();
    private String titulo;
    private String nomeConferencia; // nome da conferencia em que foi publicada
    private int anoPublicacao; // ano de publicação
    // projeto de pesquisa associado

    public Publicacao(String titulo, String nomeConferencia, int anoPublicacao){
        this.titulo = titulo;
        this.nomeConferencia = nomeConferencia;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public int getAnoPublicacao(){
        return this.anoPublicacao;
    }
}

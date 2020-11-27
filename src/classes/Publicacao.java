package src.classes;

public class Publicacao extends ProducaoAcademica{
    private String titulo;
    private String nomeConferencia; // nome da conferencia em que foi publicada
    private int anoPublicacao; // ano de publicação
    // projeto de pesquisa associado

    public Publicacao(String titulo, String nomeConferencia, int anoPublicacao){
        this.titulo = titulo;
        this.nomeConferencia = nomeConferencia;
        this.anoPublicacao = anoPublicacao;
    }
}

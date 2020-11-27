package src.classes;

public class Aluno extends Colaborador{
    public String tipo; // Graduação, mestrado ou doutorado
    private int qtdProjetos;

    public Aluno(String nome, String email, String tipo){
        super(nome, email);
        this.tipo = tipo;
        this.qtdProjetos = 0;
    }

    public int getQtdProjetos() {
        return this.qtdProjetos;
    }

    public void addQtdProjeto(){
        this.qtdProjetos++;
    }
}

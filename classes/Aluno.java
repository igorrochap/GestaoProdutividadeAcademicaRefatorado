package classes;

public class Aluno extends Colaborador{
    public String tipo; // Graduação, mestrado ou doutorado
    private int projetos;

    public Aluno(String nome, String email, String tipo){
        super(nome, email);
        this.tipo = tipo;
        this.projetos = 0;
    }

    public int getProjetos() {
        return projetos;
    }

    public void addProjeto(){
        this.projetos++;
    }
}

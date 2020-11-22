package classes;

public class Aluno extends Colaborador{
    private String tipo; // Graduação, mestrado ou doutorado

    public Aluno(String nome, String email, String tipo){
        super(nome, email);
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }
}

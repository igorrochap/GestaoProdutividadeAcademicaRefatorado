package classes;

public class Colaborador{
    private String nome;
    private String email;
    public static int contador = 3;

    public Colaborador(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }
}
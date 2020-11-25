package classes;

public class Colaborador{
    private String nome;
    private String email;
    private static int qtdColaboradores = 0;

    public Colaborador(String nome, String email){
        this.nome = nome;
        this.email = email;
        qtdColaboradores++;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public static int getQtd(){
        return qtdColaboradores;
    }
}
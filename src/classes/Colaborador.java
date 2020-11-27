package src.classes;

import java.util.ArrayList;

public class Colaborador{
    private String nome;
    private String email;
    private static int qtdColaboradores = 0;
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>(); 

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

    public void addProjeto(Projeto projeto){
        this.projetos.add(projeto);
    }

    public ArrayList<Projeto> getProjetos(){
        return this.projetos;
    }
}
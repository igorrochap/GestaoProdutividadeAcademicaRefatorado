package src.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<Projeto> sortDescending(){
        //sort();
        Collections.sort(this.projetos, new Comparator<Projeto>(){
            public int compare(Projeto projeto1, Projeto projeto2){
                return - projeto1.getDataTermino().compareTo(projeto2.getDataTermino()); // fazendo a ordenação ser decrescente
            }
        });

        return this.projetos;
    }

    public void query(){
        System.out.println("Nome do colaborador: " + this.nome);
        System.out.println("Email do colaborador: " + this.email);
        ArrayList<Projeto> projetosSort = new ArrayList<Projeto>();

        projetosSort = sortDescending();
        for(int i = 0; i < this.projetos.size(); i++){

            System.out.println("Projeto " + (i+1) + ": " + projetosSort.get(i).getTitulo());
        }
    }
}
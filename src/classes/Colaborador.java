package src.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Colaborador{
    private String nome;
    private String email;
    private static int qtdColaboradores = 0;
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
    private ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();

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
    
    public void addPublicacao(Publicacao publicacao){
        this.publicacoes.add(publicacao);
    }

    public ArrayList<Projeto> getProjetos(){
        return this.projetos;
    }

    public ArrayList<Projeto> sortDescendingProj(){
        //sort();
        Collections.sort(this.projetos, new Comparator<Projeto>(){
            public int compare(Projeto projeto1, Projeto projeto2){
                return - projeto1.getDataTermino().compareTo(projeto2.getDataTermino()); // fazendo a ordenação ser decrescente
            }
        });

        return this.projetos;
    }

    public ArrayList<Publicacao> sortDescendingPubli(){
        Collections.sort(this.publicacoes, new Comparator<Publicacao>(){
            public int compare(Publicacao publicacao1, Publicacao publicacao2){
                Integer a1 = publicacao1.getAnoPublicacao(); // argumento 1
                Integer a2 = publicacao2.getAnoPublicacao(); // argumento 2
                return - a1.compareTo(a2); // retornando em ordem descrescente
            }
        });

        return this.publicacoes;
    }

    public void query(){
        System.out.println("Nome do colaborador: " + this.nome);
        System.out.println("Email do colaborador: " + this.email);
        ArrayList<Projeto> projetosSort = new ArrayList<Projeto>();
        ArrayList<Publicacao> publiSort = new ArrayList<Publicacao>();

        projetosSort = sortDescendingProj();
        for(int i = 0; i < this.projetos.size(); i++){
            System.out.println("  Projeto " + (i+1) + ": " + projetosSort.get(i).getTitulo());
        }

        publiSort = sortDescendingPubli();
        for(int i = 0; i < this.publicacoes.size(); i ++){
            System.out.println("  Produção " + (i + 1) + ": " + publiSort.get(i).getTitulo());
        }
    }

    public static void queryColaborador(ArrayList<Colaborador> colaboradores){
        int col;
        Scanner c = new Scanner(System.in); //scanner do colaborador selecionado

        for(int i = 0; i < colaboradores.size(); i++){
            System.out.println("["  +i +"] " + colaboradores.get(i).getNome());
        }

        System.out.print("Selecione o colaborador que deseja consultar os dados: ");
        try{
            col = c.nextInt();
            Colaborador colaborador = colaboradores.get(col);
            System.out.println();
            colaborador.query();
        }
        catch(InputMismatchException error){
            System.err.println("Por favor, selecione uma das opções válidas.");
            queryColaborador(colaboradores);
        }
    }
}
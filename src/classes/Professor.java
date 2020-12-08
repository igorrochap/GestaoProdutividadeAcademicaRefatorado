package src.classes;

import java.util.ArrayList;

public class Professor extends Colaborador{
    private ArrayList<Aluno> orientados = new ArrayList<Aluno>(); 

    public Professor(String nome, String email){
        super(nome, email);
    }

    public void setOrientados(Aluno aluno){
        orientados.add(aluno);
    }
}

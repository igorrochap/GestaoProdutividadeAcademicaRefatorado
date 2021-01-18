package src.classes.state;

import src.classes.Projeto;

public class ConcluidoState implements State{
    private Projeto projeto;

    public ConcluidoState(Projeto projeto){
        this.projeto = projeto;
    }

    public void changeStatus(){
        System.out.println("Projeto já está concluído!");
    }

    public String toString() {
		return "Concluido";
	}
}

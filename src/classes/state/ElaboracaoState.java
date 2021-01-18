package src.classes.state;

import java.util.ArrayList;
import src.classes.Projeto;

public class ElaboracaoState implements State{
    private Projeto projeto;

    public ElaboracaoState(Projeto projeto){
        this.projeto = projeto;
    }

    public void changeStatus(){
        projeto.setStatus(projeto.getAndamentoState());
        
        ArrayList<Integer> values = projeto.alterarQuantidade(Projeto.getQtdProjetosElaboracao(), Projeto.getQtdProjetosAndamento());
        
        Projeto.setQtdProjetosElaboracao(values.get(0));
        Projeto.setQtdProjetosAndamento(values.get(1));

        System.out.println("O projeto agora está em andamento!");
    }
    
    public String toString() {
		return "Em elaboração";
	}
}

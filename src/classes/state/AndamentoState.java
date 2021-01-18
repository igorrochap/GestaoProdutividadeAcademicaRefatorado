package src.classes.state;

import java.util.ArrayList;
import src.classes.Projeto;

public class AndamentoState implements State{
    private Projeto projeto;

    public AndamentoState(Projeto projeto){
        this.projeto = projeto;
    }

    public void changeStatus(){
        if(projeto.getPublicacoes().size() > 0) {
            projeto.setStatus(projeto.getConcluidoState());
            
            ArrayList<Integer> values =projeto.alterarQuantidade(Projeto.getQtdProjetosAndamento(), Projeto.getQtdProjetosConcluidos());
        
            Projeto.setQtdProjetosAndamento(values.get(0));
            Projeto.setQtdProjetosConcluidos(values.get(1));

            System.out.println("Projeto concluido!");
        }
        else {
            System.out.println("Para alterar o status para 'Concluido', o projeto deve ter publicações associadas");
        }
    }

    public String toString() {
		return "Em andamento";
	}
}

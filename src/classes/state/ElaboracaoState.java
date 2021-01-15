package src.classes.state;

import src.classes.Projeto;

public class ElaboracaoState implements State{
    private State andamentoState;
    private Projeto projeto;

    public ElaboracaoState(Projeto projeto){
        this.projeto = projeto;
    }

    public void changeStatus(){
        projeto.setStatus(projeto.getAndamentoState());
        projeto.alterarQuantidade(Projeto.getQtdProjetosElaboracao(), Projeto.getQtdProjetosAndamento());
        System.out.println("O projeto agora está em andamento!");
    }
    
    public String toString() {
		return "Em elaboração";
	}
}

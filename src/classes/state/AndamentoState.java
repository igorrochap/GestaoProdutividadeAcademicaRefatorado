package src.classes.state;

import src.classes.Projeto;

public class AndamentoState implements State{
    private State concluidoState;
    private Projeto projeto;

    public AndamentoState(Projeto projeto){
        this.concluidoState = new ConcluidoState(projeto);
        this.projeto = projeto;
    }

    public void changeStatus(){
        if(projeto.getPublicacoes().size() > 0) {
            projeto.setStatus(concluidoState);
            projeto.alterarQuantidade(Projeto.getQtdProjetosAndamento(), Projeto.getQtdProjetosConcluidos());
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

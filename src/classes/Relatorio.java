package src.classes;

public class Relatorio {
    private int qtdColaboradores;
    private int qtdProjetosElaboracao;
    private int qtdProjetosAndamento;
    private int qtdProjetosConcluidos;
    private int qtdProjetos;
    private int qtdProducoes;

    public void relatorio(){
        this.qtdColaboradores = Colaborador.getQtd();
        this.qtdProjetosElaboracao = Projeto.getQtdProjetosElaboracao();
        this.qtdProjetosAndamento = Projeto.getQtdProjetosAndamento();
        this.qtdProjetosConcluidos = Projeto.getQtdProjetosConcluidos();
        this.qtdProjetos = Projeto.getQtdProjetos();
        this.qtdProducoes = ProducaoAcademica.getQtdProd();

        System.out.println("Quantidade de colaboradores do laboratório: " + this.qtdColaboradores);
        System.out.println("Quantidade de projetos em elaboração: " + this.qtdProjetosElaboracao);
        System.out.println("Quantidade de projetos em andamento: " + this.qtdProjetosAndamento);
        System.out.println("Quantidade de projetos concluidos: " + this.qtdProjetosConcluidos);
        System.out.println("Quantidade de total de projetos: " + this.qtdProjetos);
        System.out.println("Quantidade de produções acadêmicas: " + this.qtdProducoes);
    }
}

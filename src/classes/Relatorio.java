package src.classes;

public class Relatorio {
    private int qtdColaboradores; // quantidade de colaboradores
    private int qtdProjetosE; // projetos em elaboração
    private int qtdProjetosA; // projetos em andamento
    private int qtdProjetosC; // projetos concluidos
    private int qtdProjetos; // total de projetos
    private int qtdProd; // quantidade de produções academicas

    public void relatorio(){
        this.qtdColaboradores = Colaborador.getQtd();
        this.qtdProjetosE = Projeto.getQtdProjetosE();
        this.qtdProjetosA = Projeto.getQtdProjetosA();
        this.qtdProjetosC = Projeto.getQtdProjetosC();
        this.qtdProjetos = Projeto.getQtdProjetos();
        this.qtdProd = ProducaoAcademica.getQtdProd();

        System.out.println("Quantidade de colaboradores do laboratório: " + this.qtdColaboradores);
        System.out.println("Quantidade de projetos em elaboração: " + this.qtdProjetosE);
        System.out.println("Quantidade de projetos em andamento: " + this.qtdProjetosA);
        System.out.println("Quantidade de projetos concluidos: " + this.qtdProjetosC);
        System.out.println("Quantidade de total de projetos: " + this.qtdProjetos);
        System.out.println("Quantidade de produções acadêmicas: " + this.qtdProd);
    }
}

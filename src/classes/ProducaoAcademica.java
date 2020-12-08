package src.classes;

import java.util.ArrayList;

public class ProducaoAcademica {
    private static int qtdProd = 0;

    public void orientacao(Professor professor, Aluno aluno){
        qtdProd++;
        professor.setOrientados(aluno);
    }

    public static int getQtdProd(){
        return qtdProd;
    }

    public void setQtdProd(){
        qtdProd++;
    }
}

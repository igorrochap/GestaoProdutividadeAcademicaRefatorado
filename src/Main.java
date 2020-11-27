package src;

import java.util.ArrayList;

import src.classes.Aluno;
import src.classes.Colaborador;
import src.classes.ProducaoAcademica;
import src.classes.Professor;
import src.classes.Projeto;

public class Main {
    public static void main(String[] args) {
        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("* SISTEMA DE PRODUTIVIDADE ACADÊMICA *");
        System.out.println("*                                    *");
        System.out.println("**************************************");
        
        Colaborador prof = new Professor("Jorge", "jorge@jorge");
        Colaborador mar = new Aluno("Mauro", "maurin@mau", "Graduação");
        Projeto prj = new Projeto("titulo", "12/12/2012", "12/12/2013", "Caixa economica", 200, "objetivo", "descricao", prof);
        
        //prj.alocaColaborador(prof);
        //prj.alocaColaborador(mar);
        
        ArrayList<Projeto> pr = new ArrayList<Projeto>(prof.getProjetos());
        
        System.out.println(pr);
    }
}

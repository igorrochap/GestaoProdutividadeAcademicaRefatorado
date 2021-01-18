package src.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class ProducaoAcademica {
    private static int qtdProd = 0;

    public static void newProdAcad(ArrayList<Colaborador> colaboradores, ArrayList<Colaborador> autores, 
                                   ArrayList<Professor> professores,  ArrayList<Aluno> alunos, ArrayList<Publicacao> producoes){
        try{
            Scanner op = new Scanner(System.in); //scanner da opção
            String s; // opção de continuar adicionando autores
    
            System.out.println("**********************");
            System.out.println("*  [1] Publicação    *");
            System.out.println("*  [2] Orientação    *");
            System.out.println("**********************");
            System.out.print("Selecione a opção desejada: ");
            int opt = op.nextInt();
    
            if(opt == 1){
                Scanner a = new Scanner(System.in); // scanner dos autores da publicação
                Scanner sn = new Scanner(System.in); // scanner sim/nao
                Scanner t = new Scanner(System.in); // scanner do titulo
                Scanner con = new Scanner(System.in); // scanner da conferencia
                Scanner ap = new Scanner(System.in); // scanner do ano de apresentação da publicação
                
                do{
                    System.out.println("Informe os autores da publicação: ");
                    for(int i = 0; i < colaboradores.size(); i++){
                        System.out.println("["+ i +"] " + colaboradores.get(i).getNome());
                    }
                    int au = a.nextInt();
                    Colaborador c = colaboradores.get(au);
                    autores.add(c);
    
                    System.out.println("Existem mais autores da publicação? [S/N]: ");
                    s = sn.nextLine();
                } while(s.equalsIgnoreCase("S"));
    
                System.out.print("Informe o titulo da publicação: ");
                String titulo = t.nextLine();
    
                System.out.println();
                
                System.out.print("Informe o nome da conferência em que a publicação foi apresentada: ");
                String nomeConferencia = con.nextLine();
                
                System.out.println();
    
                System.out.print("Informe em que ano a publicação foi apresentada: ");
                int anoPublicacao = ap.nextInt();
    
    
                ProducaoAcademica prod = new Publicacao(titulo, nomeConferencia, anoPublicacao, autores);
                producoes.add((Publicacao) prod);

                System.out.println("Publicação adicionada ao sistema!");
                Publicacao publicacao = (Publicacao) prod;
                for(int i = 0; i < autores.size(); i++){
                    autores.get(i).addPublicacao(publicacao);
    
                    autores.remove(i);
                }
            }
            else if(opt == 2){
                Scanner al = new Scanner(System.in);
                Scanner p = new Scanner(System.in); 
    
                for(int i = 0; i < alunos.size(); i++){
                    System.out.println("    [" + i + "] " + alunos.get(i).getNome());
                }
    
                System.out.print("Selecione o aluno a ser orientado: ");
                int alu = al.nextInt();
    
                Aluno aluno = alunos.get(alu);
    
                for(int i = 0; i < professores.size(); i++){
                    System.out.println("    [" + i + "] " + professores.get(i).getNome());
                }
    
                System.out.print("Selecione o professor que irá orientar: ");
                int prof = p.nextInt();
    
                Professor professor = professores.get(prof);
                ProducaoAcademica orientacao = new ProducaoAcademica();
    
                orientacao.orientacao(professor, aluno);

                System.out.println("Orientação adicionada ao sistema!");
            }
        }
        catch(Exception ex){
            System.err.println("Dados informados incorretamente! Por favor, informe os dados corretamente.");
            newProdAcad(colaboradores, autores, professores, alunos, producoes);
        }
    }

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

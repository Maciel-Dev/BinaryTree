import geradorarquivos.GeradorArquivos;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Gerador e leitor de Arquivo
        GeradorArquivos g = new GeradorArquivos();

        int TAM = 50;
        g.geraArquivo(TAM, GeradorArquivos.TipoArquivo.ORDENADO);

        // Inicialização de Comparadores
        CompareByCode compareByCode = new CompareByCode();
        CompareByName compareByName = new CompareByName();

        //Inicialização Arvore

        // Todo - Read all file and create 2 binary tree from reader - Objectives - Don't use List
        FReader reader = new FReader();
        Arvore<Aluno> SByCode = reader.reader("entradaOrdenada50", compareByCode);
        Arvore<Aluno> SByName = reader.reader("entradaOrdenada50", compareByName);

        SByCode.pesquisarElemento(SByCode.getRoot(), 200000);

        // Retorno da Lista de Alunos Preenchida
        List<Aluno> listAluno = reader.getClasse().getListAluno();

        Scanner sc = new Scanner(System.in);

        //Inicialização do Menu
        Menu.textoInicial();
        Menu.acoes();
        int userAnsw = sc.nextInt();

        if(userAnsw == 1){
            Menu.adicionarElemento();
            System.out.println("Digite a matrícula do aluno: ");
            int matricula = sc.nextInt();
            System.out.println("Digite o nome do aluno: ");
            String nomeAluno = sc.nextLine();
            System.out.println("Digite a nota do aluno: ");
            Double grade = sc.nextDouble();

            Aluno aluno = new Aluno(matricula, nomeAluno, grade);
            SByCode.add(aluno);
            SByName.add(aluno);
        }
        else if(userAnsw == 2){
            Menu.selecaoMatricula();
            int userAnswM = sc.nextInt();
            if(userAnsw == 1){
                Menu.BuscarMat();
            }
        }
    }
}
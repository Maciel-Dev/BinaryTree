import geradorarquivos.GeradorArquivos;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Gerador e leitor de Arquivo
        GeradorArquivos g = new GeradorArquivos();
        FReader reader = new FReader();
        int TAM = 50;
        g.geraArquivo(TAM, GeradorArquivos.TipoArquivo.ORDENADO);
        reader.reader("entradaOrdenada50");

        // Retorno da Lista de Alunos Preenchid
        List<Aluno> listAluno = reader.getClasse().getListAluno();
        Arvore<Aluno> arvore = new Arvore<>();

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
        }
    }
}
import geradorarquivos.GeradorArquivos;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        GeradorArquivos g = new GeradorArquivos();
        FReader reader = new FReader();

        int TAM = 100000000;
        long tempoInicial = System. currentTimeMillis();
        g.geraArquivo(TAM, GeradorArquivos.TipoArquivo.ORDENADO);
        long tempoFinal = System. currentTimeMillis();

        System.out.println("Tempo Total de geração do arquivo em ms: " + (tempoFinal - tempoInicial));

        reader.reader("entradaOrdenada50");

        List<Aluno> listAluno = reader.getClasse().getListAluno();

        Arvore<Aluno> arvore = new Arvore<Aluno>();

//        for(Aluno a : listAluno){
//            arvore.add(a);
//        }
//
//        arvore.StraightWalk();
    }
}
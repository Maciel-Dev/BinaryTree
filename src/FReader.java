// Autor: João Vitor Maciel Vianna

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FReader<T extends Comparable> {
    static String line;
    Comparator<T> comparator;

    public Arvore<T> reader(String fileName, Comparator<T> comparator) throws IOException {

        Arvore<T> arvoreAluno = new Arvore<>(comparator);
        ArvoreAVL<T> arvoreAVL = new ArvoreAVL<>(comparator);
        this.comparator = comparator;

        File file = new File( fileName + ".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        boolean first = true;

        while((line = br.readLine()) != null){
            if(first){
                first = false;
                arvoreAluno.setQuant(Integer.parseInt(line));
            }

            else {
                String[] parts = line.split(";");
                Aluno aluno = new Aluno(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
                arvoreAluno.add((T) aluno);
            }
        }

        return arvoreAluno;
    }

    public ArvoreAVL<T> readerAVL(String fileName, Comparator<T> comparator) throws IOException {

        ArvoreAVL<T> arvoreAVL = new ArvoreAVL<>(comparator);
        this.comparator = comparator;

        File file = new File( fileName + ".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        boolean first = true;

        while((line = br.readLine()) != null){
            if(first){
                first = false;
                arvoreAVL.setQuant(Integer.parseInt(line));
            }

            else {
                String[] parts = line.split(";");
                Aluno aluno = new Aluno(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
                arvoreAVL.adicionarElemento((T) aluno);
            }
        }

        return arvoreAVL;
    }


}


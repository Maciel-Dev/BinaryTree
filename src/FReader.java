import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FReader<T extends Comparable> {
    static String line;
    Classe classe = new Classe();
    Comparator<T> comparator;

    public Arvore<T> reader(String fileName, Comparator<T> comparator) throws IOException {

        Arvore<T> arvoreAluno = new Arvore<T>(comparator);
        this.comparator = comparator;

        File file = new File( fileName + ".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        boolean first = true;

        while((line = br.readLine()) != null){
            if(first){
                first = false;
                classe.setQuantity(Integer.parseInt(line));
            }

            else {
                String[] parts = line.split(";");
                Aluno aluno = new Aluno(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
                arvoreAluno.add((T) aluno);
            }
        }

        return arvoreAluno;
    }

    public Classe getClasse(){
        return classe;
    }

    public ArrayList<String> getMatriculas(){
        return this.classe.getMatriculas();
    }
}


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FReader {

    static String line;
    Classe classe = new Classe();

    public void reader(String fileName) throws IOException {
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
                Aluno aluno = new Aluno();
                aluno.setCode(parts[0]);
                aluno.setName(parts[1]);
                aluno.setGrade(Float.parseFloat(parts[2]));
                classe.setListAluno(aluno);
                classe.setMatriculas(parts[0]);
            }
        }
//        classe.PrintLista();
        classe.getListAluno();
    }

    public Classe getClasse(){
        return classe;
    }

    public ArrayList<String> getMatriculas(){
        return this.classe.getMatriculas();
    }
}


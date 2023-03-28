import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FReader {

    static String line;

    private static List<Aluno> list = new ArrayList<Aluno>();

    public static void reader(String fileName) throws IOException {
        File file = new File("FileDirectory/" + fileName + ".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        boolean first = true;

        Classe classe = new Classe();

        while((line = br.readLine()) != null){
            if(first){
                first = false;
            }

            else {
                String[] parts = line.split(";");
                Aluno aluno = new Aluno();
                aluno.setCode(parts[0]);
                aluno.setName(parts[1]);
                aluno.setGrade(Float.parseFloat(parts[2]));

                classe.setListAluno(aluno);
            }
        }
        classe.PrintLista();
    }
}


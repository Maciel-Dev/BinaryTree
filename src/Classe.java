import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classe {

    private int quantity;
    private ArrayList<Aluno> listAluno;
    private ArrayList<String> matriculas;

    public Classe(){
        listAluno = new ArrayList<Aluno>();
        matriculas = new ArrayList<String>();
        this.quantity = 0;
    }

    public void setListAluno(ArrayList<Aluno> listAluno) {
        this.listAluno = listAluno;
    }

    public ArrayList<String> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(String matricula) {
        matriculas.add(matricula);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Aluno> getListAluno() {
        return listAluno;
    }

    public void PrintLista(){
        for(Aluno aluno : listAluno){
            System.out.println(aluno.getCode() + " - " + aluno.getName() + " - " + aluno.getGrade());
        }
    }

    public void setListAluno(Aluno aluno) {
        listAluno.add(aluno);
    }
}

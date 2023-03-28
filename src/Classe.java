import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classe {

    public int quantity;
    public ArrayList<Aluno> listAluno;

    public Classe(){
        this.listAluno = new ArrayList<Aluno>();
        this.quantity = 0;

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
        for(Aluno aluno : this.listAluno){
            System.out.println(aluno.getCode() + " - " + aluno.getName() + " - " + aluno.getGrade());
        }
    }

    public void setListAluno(Aluno aluno) {
        listAluno.add(aluno);
    }
}

import java.util.Comparator;

public class CompareByCode extends Compa implements Comparator<Aluno> {
    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Integer.compare(o1.getCode(), o2.getCode());
    }

    @Override
    public int getMatricula(Aluno aluno) {
        return super.getMatricula(aluno);
    }

    public int getCode(Aluno aluno){
        return aluno.getCode();
    }
    public int compareCode(int code, int codeCompare){
        return Integer.compare(code, codeCompare);
    }
}

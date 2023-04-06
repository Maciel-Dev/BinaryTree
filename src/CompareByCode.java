import java.util.Comparator;

public class CompareByCode implements Comparator<Aluno> {
    @Override
    public int compare(Aluno o1, Aluno o2) {
        return  Integer.compare(Integer.parseInt(o1.getCode()), Integer.parseInt(o2.getCode()));
    }
}

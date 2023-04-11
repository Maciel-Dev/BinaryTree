// Autor: João Vitor Maciel Vianna

import java.util.Comparator;

public class CompareByCode implements Comparator<Aluno> {
    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Integer.compare(o1.getCode(), o2.getCode());
    }

}

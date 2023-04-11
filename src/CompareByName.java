// Autor: João Vitor Maciel Vianna

import java.util.Comparator;

public class CompareByName implements Comparator<Aluno> {

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

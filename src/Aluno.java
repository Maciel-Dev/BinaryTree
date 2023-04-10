import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Aluno implements Comparable<Aluno> {

    private int code;
    private String name;
    private Double grade;
    private List<Aluno> list;

    public Aluno(int code, String name, Double grade){
        this.code = code;
        this.name = name;
        this.grade = grade;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public List<Aluno> getList() {
        return list;
    }

    public void setList(Aluno aluno) {
        this.list.add(aluno);
    }

    @Override
    public int compareTo(Aluno o) {
        return 0;
    }
}

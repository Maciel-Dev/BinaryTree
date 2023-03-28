import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Aluno implements Comparable {

    private String code;
    private String name;
    private float grade;
    private List<Aluno> list;

    public Aluno(){
        this.code = null;
        this.name = null;
        this.grade = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public List<Aluno> getList() {
        return list;
    }

    public void setList(Aluno aluno) {
        this.list.add(aluno);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

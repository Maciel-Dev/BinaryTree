public class Elemento<T> {
    private T value;
    private Elemento<T> left;
    private Elemento<T> right;

    public Elemento(T valor){
        this.value = valor;
        this.left = null;
        this.right = null;
    }

    public Elemento(){
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Elemento<T> getLeft() {
        return left;
    }

    public void setLeft(Elemento<T> left) {
        this.left = left;
    }

    public Elemento<T> getRight() {
        return right;
    }

    public void setRight(Elemento<T> right) {
        this.right = right;
    }
}

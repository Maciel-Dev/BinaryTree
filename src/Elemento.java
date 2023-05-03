// Autor: João Vitor Maciel Vianna

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

    public int obterAltura(){
        return obterAltura(this);
    }

    private int obterAltura(Elemento<T> r){
        if(r == null){
            return -1;
        }
        else{
            int hd = obterAltura(r.getRight());
            int he = obterAltura(r.getLeft());
            if(hd > he){
                return hd+1;
            }
            else{
                return he+1;
            }
        }
    }

    public int fatorBalanceamento(){
        return obterAltura(this.right) - obterAltura(this.left);
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

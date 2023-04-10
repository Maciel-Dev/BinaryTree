import java.util.Comparator;

public class Arvore<T extends Comparable> {
    private Elemento<T> root;
    private String tipo;
    private Comparator<T> comparator;


    public Arvore(Comparator<T> comparator){
        this.root = null;
        this.comparator = comparator;
    }

    // Element append on BinaryTree
    public void add(T value){
        Elemento<T> newElement = new Elemento<T>(value);
        if(root == null){
            this.root = newElement;
        }
        else {
            Elemento<T> atual = this.root;
            while(true){
                if(comparator.compare(newElement.getValue(), atual.getValue()) < 0){
                    if(atual.getLeft() != null){
                        atual = atual.getLeft();
                    }
                    else{
                        atual.setLeft(newElement);
                        break;
                    }
                }
                else{
                    if(atual.getRight() != null){
                        atual=atual.getRight();
                    }
                    else{
                        atual.setRight(newElement);
                        break;
                    }
                }
            }
        }
    }

    // Straight walk
    public void StraightWalk(){
        System.out.println("Initializing Straight Walk:");
        PrintTree(this.root);
        System.out.println("Finishing Walk");
    }

    // Printing Tree
    private void PrintTree(Elemento<T> root){
        if(root != null){
            PrintTree(root.getLeft());
            System.out.println(root.getValue());
            PrintTree(root.getRight());
        }
    }

    public boolean pesquisarElemento(Elemento<T> elemento, int matricula){

        if()

        if (elemento.getValue() == null) {
            return false;
        }
        else if(elemento.getValue().equals(matricula)){
            return true;
        }
//        else if(comparator.(elemento.getValue(), matricula) < 0)
        else if(comparator. < 0){
            return pesquisarElemento(elemento.getLeft(), matricula);
        }
        else{
            return pesquisarElemento(elemento.getRight(), matricula);
        }
    }

    public Elemento<T> getRoot() {
        return root;
    }

    public void setRoot(Elemento<T> root) {
        this.root = root;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
}


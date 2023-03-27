public class Arvore<T extends Comparable> {
    private Elemento<T> root;

    public Arvore(){
        this.root = null;
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
                if(newElement.getValue().compareTo(atual.getValue()) == -1){
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
}

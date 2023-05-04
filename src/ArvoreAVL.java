import java.util.Comparator;

public class ArvoreAVL <T extends Comparable> extends Arvore<T>{

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    // Rotação a Esquerda
    // Caso necessário a rotação,
    // Obtém o elemento da inserção de recursão
    // Cria um novo Elemento e aponta para o filho a direita do elemento atual
    // Obtem o filho a esquerda do filho a direita
    // O filho a direita do elemento (Parametro) aponta para o filho a esquerda de f
    // o filho a esquerda de f aponta para r, ocasionando a rotação
    private Elemento<T> rotacaoEsquerda(Elemento<T> r){
        Elemento<T> f = r.getRight();
        r.setRight(f.getLeft());
        f.setLeft(r);
        return f;
    }

    // Rotação a Diretia
    // Caso necessário a rotação,
    // Obtém o elemento da inserção de recursão
    // Cria um novo Elemento e aponta para o filho a esquerda do elemento atual
    // Obtem o filho a direita do filho a esquerda
    // O filho a esquerda do elemento (Parametro) aponta para o filho a direita de f
    // o filho a direita de f aponta para r, ocasionando a rotação
    private Elemento<T> rotacaoDireita(Elemento<T> r){
        Elemento<T> f = r.getLeft();
        r.setLeft(f.getRight());
        f.setRight(r);
        return f;
    }

    private Elemento<T> rotacaoEsquerdaDireita(Elemento<T> r){
        r.setLeft(rotacaoEsquerda(r.getLeft()));
        return rotacaoDireita(r);
    }

    private Elemento<T> rotacaoDireitaEsquerda(Elemento<T> r){
        r.setRight(rotacaoDireita(r.getRight()));
        return rotacaoEsquerda(r);
    }

    @Override
    protected Elemento<T> addRecursivo(Elemento<T> raiz, Elemento<T> novo){
        raiz = super.addRecursivo(raiz,novo);

        if(raiz.fatorBalanceamento() > 1){
            if(raiz.getRight().fatorBalanceamento() > 0){
                raiz = this.rotacaoEsquerda(raiz);
            }
            else{
                raiz = this.rotacaoDireitaEsquerda(raiz);
            }
        }
        else if(raiz.fatorBalanceamento() < -1){
            if(raiz.getLeft().fatorBalanceamento() < 0){
                raiz = this.rotacaoDireita(raiz);
            }
            else{
                raiz = this.rotacaoEsquerdaDireita(raiz);
            }
        }
        return raiz;
    }

    public void addRecursivo(T value) {
       root = addRecursivo(root, new Elemento<T>(value));
    }
}

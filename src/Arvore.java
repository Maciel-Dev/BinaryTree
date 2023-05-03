// Autor: João Vitor Maciel Vianna

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.LinkedList;


public class Arvore<T extends Comparable> {
    private Elemento<T> root;
    private String tipo;
    private Comparator<T> comparator;
    private int quant;


    public Arvore(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    //----------------------------------------------------

    // Element append on BinaryTree
    //  Recebe um Objeto de Tipo T, Genérico
    // Realiza comparação se baseando no comparable passado(Code ou Name)
    public void add(T value) {
        Elemento<T> newElement = new Elemento<>(value);
        if (root == null) {
            this.root = newElement;
        } else {
            Elemento<T> atual = this.root;
            while (true) {
                if (comparator.compare(newElement.getValue(), atual.getValue()) < 0) {
                    if (atual.getLeft() != null) {
                        atual = atual.getLeft();
                    } else {
                        atual.setLeft(newElement);
                        break;
                    }
                } else {
                    if (atual.getRight() != null) {
                        atual = atual.getRight();
                    } else {
                        atual.setRight(newElement);
                        break;
                    }
                }
            }
        }
    }

    //Adicionar Recursivo
    protected Elemento<T> addRecursivo(Elemento<T> raiz, Elemento<T> valor){
        if(raiz == null){
            return new Elemento<T>(valor.getValue());
        }

        if(comparator.compare(raiz.getValue(), valor.getValue()) < 0){
            raiz.setLeft(addRecursivo(raiz.getLeft(), valor));
        }
        else if(comparator.compare(raiz.getValue(), valor.getValue()) > 0){
            raiz.setRight(addRecursivo(raiz.getRight(), valor));
        }

        return raiz;
    }

    //---------------------------------------------------------------

    //---------------------------------------------------------------

    // Caminho em Nível
    // Straight walk
    // Método público para inicialização de caminhar em ordem
    public void StraightWalk() {
        System.out.println("Initializing Straight Walk:");
        PrintTree(this.root);
        System.out.println("Finishing Walk");
    }

    // Printing Tree
    // *Método de recursão*
    // Recebe um elemento da Árvore em questão
    // Busca primeiramente nós a esquerda
    // Caso haja nós, chama recursivamente a função e dá continuidade para o nó a direita
    private void PrintTree(Elemento<T> root) {
        if (root != null) {
            PrintTree(root.getLeft());
            System.out.println(root.getValue().toString());
            PrintTree(root.getRight());
        }
    }
    //---------------------------------------------------------------

    // Get Low name and Code
    // Busca pelo menor elemento realizando o acesso dos nós a esquerda
    // Enquanto o nó atual possuir um nó a esquerda, o no recorrente passa a ser o nó a esquerda
    public T lowElement(Elemento<T> root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getValue();
    }

    //---------------------------------------------------------------

    // Get High name and Code
    // Busca pelo maior elemento realizando o acesso dos nós a direita
    // Enquanto houver nós a direita, o nó atual assume o valor do nó a direita indicado

    public T getHighElement(Elemento<T> root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root.getValue();
    }


    //---------------------------------------------------------------

    // Walk by Level
    // Inicia com uma lista apenas com a raíz
    // *Recursivo*
    // Se a lista possuir elemento, Printa o elemento e elimina o primeiro elemento da lista
    // Consequentemente, o primeiro elemento é o próprio elemento que foi printado

    private void LevelWalk(LinkedList<Elemento<T>> lista, Elemento<T> elemento) {
        if (!lista.isEmpty()) {
            Elemento<T> first = lista.getFirst();
            System.out.println(first.getValue().toString());
            lista.removeFirst();
        }
        // Dois ifs para verificar casos onde há nó a esquerda e a direita
        // Chama recursivamente a função para verificação se há elementos na lista e print
        if (elemento.getLeft() != null) {
            lista.add(elemento.getLeft());
            LevelWalk(lista, elemento.getLeft());
        }
        if (elemento.getRight() != null) {
            lista.add(elemento.getRight());
            LevelWalk(lista, elemento.getRight());
        }
    }

    // Chamada da função - Pública
    public void initLevelWalk() {
        LinkedList<Elemento<T>> lista = new LinkedList<>();
        lista.add(this.root);
        LevelWalk(lista, this.root);
    }

    //---------------------------------------------------------------

    // Pesquisa de Elementos na Árvore
    // Recebe um elemento inicial, elemento desejado e a quantidade de elementos que foram buscados
    public T pesquisarElementoRecursivo(Elemento<T> start, Elemento<T> elemento, int quantElementos) {
        // Função verifica se o elemento inicial, variável com base na busca pela árvore, é nulo
        if (start != null) {
            // Acrésicmo da quantidade de elementos, uma vez que, se o elemento inicial não é nulo
            // já houve busca de um novo elemento
            quantElementos++;

            // Verificação se os elementos possuem o mesmo valor
            if (comparator.compare(start.getValue(), elemento.getValue()) == 0) {
                System.out.println("ALUNO ENCONTRADO!");
                System.out.println("Foram percorridos " + quantElementos + " elementos");

                return start.getValue();
            } else if (comparator.compare(start.getValue(), elemento.getValue()) > 0) {
                pesquisarElementoRecursivo(start.getLeft(), elemento, quantElementos);
            } else if (comparator.compare(start.getValue(), elemento.getValue()) < 0) {
                pesquisarElementoRecursivo(start.getRight(), elemento, quantElementos);
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
        return null;
    }

    // A pesquisa por elementoIterativo utiliza do tipo de iteração de uma função
    // Inicia pela raíz, e a partir dela, realiza comparações com o elemento Desejado
    // Atualiza a variável de início de acordo com o resultado da comparação
    // Alterar para public
    public T pesquisarElementoIterativo(T aluno) {
        Elemento<T> elemento = new Elemento<>(aluno);
        int quantElemen = 0;
        Elemento<T> inicio = this.root;
        while (inicio != null) {
            quantElemen++;
            if (comparator.compare(inicio.getValue(), elemento.getValue()) == 0) {
                System.out.println("\nAluno Encontrado! ✔ \nForam realizadas " + quantElemen + " comparações");
                return inicio.getValue();
            } else if (comparator.compare(elemento.getValue(), inicio.getValue()) < 0) {
                inicio = inicio.getLeft();
            } else if (comparator.compare(elemento.getValue(), inicio.getValue()) > 0) {
                inicio = inicio.getRight();
            }
        }
        System.out.println("Aluno não encontrado! ✘");
        return null;
    }


    //---------------------------------------------------------------
    //Remover
    protected T remove(Elemento<T> data) {
        //buscar elemento
        // Iterativo
        Elemento<T> atual = this.root;
        Elemento<T> actFather = null;
        // Realiza a busca do elemento na árvore
        // Salva o último elemento buscado como pai do próximo elemento a ser buscado
        while (atual != null) {
            if (comparator.compare(atual.getValue(), data.getValue()) == 0) {
                break;
            } else if (comparator.compare(atual.getValue(), data.getValue()) > 0) {
                actFather = atual;
                atual = atual.getLeft();
            } else {
                actFather = atual;
                atual = atual.getRight();
            }
        }
        if (atual != null) {
            //Caso o nó da direita do elemento encontrado seja diferente de null
            if (atual.getRight() != null) {
                //Armazena nó a ocupar o lugar do nó substituido
                Elemento<T> substitute = atual.getRight();
                //Armazena nó pai
                Elemento<T> subFather = atual;

                // Busca pelo nó a esquerda e atualiza
                while (substitute.getLeft() != null) {
                    subFather = substitute;
                    substitute = substitute.getLeft();
                }
                //
                substitute.setLeft(atual.getLeft());

                // Busca pelo pai atual
                if (actFather != null) {
                    if (comparator.compare(atual.getValue(), actFather.getValue()) < 0) {
                        actFather.setLeft(substitute);
                    } else {
                        actFather.setRight(substitute);
                    }
                }
                // Caso não haja pai atual, é raíz
                else {
                    this.root = substitute;
                    subFather.setLeft(null);
                    this.root.setRight(subFather);
                    this.root.setLeft(atual.getLeft());
                }
                // Realiza comparação do valor
                // Caso o valor seja menor do que o pai temporário, o pai temporário
                // aponta para um nó vazio
                if (comparator.compare(substitute.getValue(), subFather.getValue()) < 0) {
                    subFather.setLeft(null);
                } else {
                    subFather.setRight(null);
                }
            } else if (atual.getLeft() != null) { // possui filho a esquerda
                Elemento<T> substitute = atual.getLeft();
                Elemento<T> subFather = atual;
                while (substitute.getRight() != null) {
                    subFather = substitute;
                    substitute = substitute.getRight();
                }

                if (actFather != null) {
                    if (comparator.compare(atual.getValue(), actFather.getValue()) < 0) {
                        actFather.setLeft(substitute);
                    } else {
                        actFather.setRight(substitute);
                    }
                } else {
                    this.root = substitute;
                }

                if (comparator.compare(substitute.getValue(), subFather.getValue()) < 0) {
                    subFather.setLeft(null);
                } else {
                    subFather.setRight(null);
                }
            } else {
                // Caso não possua filho
                if (actFather != null) {
                    if (comparator.compare(atual.getValue(), actFather.getValue()) < 0) {
                        actFather.setLeft(null);
                    } else {
                        actFather.setRight(null);
                    }
                } else {
                    this.root = null;
                }
            }
            return atual.getValue(); // Valor Deletado
        } else {
            return null;
        }
    }

    public T initRemove(T elemento) {
        Elemento<T> newElement = new Elemento<>(elemento);
        return remove(newElement);
    }
    //---------------------------------------------------------------

    //Quantidade de Elementos

    public int quantElem(Elemento<T> r) {
        if (r == null)
            return 0;
        else {
            return quantElem(r.getLeft()) + quantElem(r.getRight()) + 1;
        }

    }

    //---------------------------------------------------------------

    //---------------------------------------------------------------
    //Get Tree Height

    public int getHeight(Elemento<T> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //---------------------------------------------------------------

//    Save Tree

    //Save Method
    private void walk(Elemento<T> el, String filename) throws IOException {
        if (el != null) {
            Aluno aluno = (Aluno) (el.getValue());
            walk(el.getLeft(), filename);
            Files.writeString(Path.of(filename), aluno.getCode() + ";" + aluno.getName() + ";" + aluno.getGrade() + "\n", StandardOpenOption.APPEND);
            walk(el.getRight(), filename);
        }
    }

    private boolean Save(String filename) throws IOException {
        Files.writeString(Path.of(filename), quantElem(this.root) + "\n", StandardOpenOption.APPEND);
        walk(this.root, filename);
        return true;
    }

    public void initSave(String filename) throws IOException {
        Files.writeString(Path.of(filename), "");
        boolean saved = Save(filename);
        if (saved) {
            System.out.println("Arquivo salvo");
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

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}


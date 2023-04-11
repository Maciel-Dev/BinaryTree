// Autor: João Vitor Maciel Vianna

import javax.swing.text.Element;
import java.util.*;

public class Arvore<T extends Comparable> {
    private Elemento<T> root;
    private String tipo;
    private Comparator<T> comparator;
    private Elemento<T> elementStat;
    private int quant;


    public Arvore(Comparator<T> comparator){
        this.root = null;
        this.comparator = comparator;
    }

    //----------------------------------------------------

    // Element append on BinaryTree
    //  Recebe um Objeto de Tipo T, Genérico
    // Realiza comparação se baseando no comparable passado(Code ou Name)
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

    //---------------------------------------------------------------

    //---------------------------------------------------------------

    // Caminho em Nível
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
    //---------------------------------------------------------------
    // Get Low name and Code
    // Busca pelo menor elemento realizando o acesso dos nós a esquerda

    private Elemento<T> lowElement(Elemento<T> root){
        while(root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }

    // Chamada da função
    public void initLow(){
        System.out.println("O aluno com a menor matrícula: " + lowElement(this.root) + "\n");
    }

    //---------------------------------------------------------------

    // Get High name and Code
    // Busca pelo maior elemento realizando o acesso dos nós a direita

    private Elemento<T> highElement(Elemento<T> root){
        while(root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }

    // Chamada da função
    public void initHigh(){
        System.out.println("O aluno com a maior matrícula: " + highElement(this.root)+ "\n");
    }

    //---------------------------------------------------------------

    // Walk by Level

    private void LevelWalk(LinkedList<Elemento<T>> lista, Elemento<T> elemento){
        if(!lista.isEmpty()){
            Elemento<T> first = lista.getFirst();
            System.out.println(first.getValue());
            lista.removeFirst();
        }
        if(elemento.getLeft() != null){
            lista.add(elemento.getLeft());
            LevelWalk(lista, elemento.getLeft());
        }
        if(elemento.getRight() != null){
            lista.add(elemento.getRight());
            LevelWalk(lista, elemento.getRight());
        }
    }

    // Chamada da função
    public void initLevelWalk(){
        LinkedList<Elemento<T>> lista = new LinkedList<>();
        lista.add(this.root);
        LevelWalk(lista, this.root);
    }

    //---------------------------------------------------------------
    // Pesquisa de Elementos na Árvore

    private void pesquisarElemento(Elemento<T> start, Elemento<T> elemento, int quantElementos){
        if(start != null){
            quantElementos++;
            if(comparator.compare(start.getValue(), elemento.getValue()) == 0){
                System.out.println("ALUNO ENCONTRADO!");
                System.out.println("Foram percorridos " + quantElementos + " elementos");
            }
            else if(comparator.compare(start.getValue(), elemento.getValue()) > 0){
                pesquisarElemento(start.getLeft(), elemento, quantElementos);
            }
            else if(comparator.compare(start.getValue(), elemento.getValue()) < 0){
                pesquisarElemento(start.getRight(), elemento, quantElementos);
            }
        }
        else{
            System.out.println("Aluno não encontrado!");
        }
    }

    public void search(T element){
        Elemento<T> val = new Elemento<T>(element);
        pesquisarElemento(this.root ,val, 0);
    }

    //---------------------------------------------------------------
    //Remover

    //---------------------------------------------------------------


    //---------------------------------------------------------------
    //Quantidade de Elementos

    private int quantElementos(Elemento<T> elemento, int quant){
        while(elemento != null){
            quant++;
            if(elemento.getLeft() != null){
                elemento = elemento.getLeft();
            }
            else{
                elemento = elemento.getRight();
            }
        }

        return quant;
    }

    public void initQuant(){
        int quant = quantElementos(this.root, 0);
        System.out.println(quant);
    }

    //---------------------------------------------------------------

    //---------------------------------------------------------------
    //Get Tree Height


    private int height(Elemento<T> elemento){
        if(elemento == null){
            return 0;
        }
        Queue<Elemento<T>> queue = new ArrayDeque<>();
        queue.add(this.root);

        Elemento<T> first = null;
        int height = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size -- > 0){
                first = queue.poll();

                if(first.getLeft() != null){
                    queue.add(first.getLeft());
                }
                if(first.getRight() != null){
                    queue.add(first.getRight());
                }
            }
            height++;
        }

        return height;
    }

    public int initHeight(){
        return height(this.root);
    }
    //---------------------------------------------------------------


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


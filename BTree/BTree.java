package BTree;

/**
 * Clase Arbol B de tipo genérico.
 * 
 * @author Jhon Franklin Panocca Merma
 */
public class BTree<T extends Comparable<T>> {
    
    private class Node<E>{

        int n; // Numero de claves que puede guardar el nodo
        E[] keys;

        public Node<E> child[]; // Arreglo para guardar los hijos del nodo

        public Node(int t){
            this.n = 0;


        }

        public boolean isLeaf(){
            return true;
        }
    }
    /**
     * Raiz del arbol
     */
    private Node<T> root;

    /**
     * Grado minimo
     */
    private int t;


    public BTree(int t){
        this.t = t;
        this.root = new Node<T>(t);
    }
}


/**
 * VIDEO PARA ELABORAR EL CODIGO:
 * https://www.youtube.com/watch?v=fBWcZ4yBYPk
 * 
 */
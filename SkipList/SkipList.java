
package SkipList;

/**
 * SkipList
 */
public class SkipList<T extends Comparable<T>> {

    /**
     * Tree Node Private Class
     */
    private class Node<E>{
        public E element;
        public Node<E> right, down;

        public Node(E element){
            this(element,null,null);
        }
        public Node(E element, Node<E> right, Node<E> down){
            this.element = element;
            this.right = right;
            this.down = down;
        }
    }
    /**  */
    private Node<T> header;
    private Node<T> bottom = null;
    private int infinity;

    public void insert(T element){
        this.header = insert(element, this.header);

    }
    public Node<T> insert(T element, Node<T> header){
        return null;
    }
}
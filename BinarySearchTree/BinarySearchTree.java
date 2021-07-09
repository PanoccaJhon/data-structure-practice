package BinarySearchTree;
import java.lang.Exception;

public class BinarySearchTree<T extends Comparable<T>> {
    
    private class Node<E>{
        Node<E> left, right;
        E data;
        public Node(E data){
            this(data, null,null);
        }
        public Node(E data, Node<E> left, Node<E> right){
            this.data = data;
            this.left = left;
            this.right = right;
        } 
    }

    //Objeto raiz de arbol
    private Node<T> root;


    // Constructor
    public BinarySearchTree(){
        this.root = null;
    }

    // Funciones importantes:


    // Insertar un elemento
    public void insert(T x) throws ItemDuplicated{
        this.root = insertNode(x, this.root);
    }
    public Node<T> insertNode(T x, Node<T> current) throws ItemDuplicated{
        Node<T> res = current;
        if(current == null) 
            res = new Node<T>(x);
        else {
            int resC = current.data.compareTo(x);
            if(resC==0) throw new ItemDuplicated(x+" esta duplicado");
            if(resC < 0) res.right = insertNode(x, current.left);
            else res.left = insertNode(x,current.left);
        }
        return res;
    }
    
    // Eliminacion de un elemento
    public void remove(T x) throws ItemNotFound{
        this.root = removeNode(x, this.root);
    }
    private Node<T> removeNode(T x, Node<T> current) throws ItemNotFound {
        Node<T> res = current;
        if(current == null) throw new ItemNotFound(x+" no se encuentra");
        int resC = current.data.compareTo(x);
        if(resC<0) res.right = removeNode(x, current.right);
        else if(resC>0) res.left = removeNode(x,current.left);
        else if(current.left!=null&&current.right!=null){
            res.data = minRecover(current.right).data;
            res.right = minRemove(current.right);
        }else{
            res = (current.left != null) ? current.left:current.right;
        }
        return res;
    }
    public T minRemove(){
        T min = minRecover();
        this.root = minRemove(this.root);
        return min;
    }
    public Node<T> minRemove(Node<T> current){
        if(current.left!=null){
            current.left = minRemove(current.left);
        }else{
            current = current.right;
        }
        return current;
    }
    public T minRecover(){
        T min = minRecover(this.root).data;
        return min;
    }
    public Node<T> minRecover(Node<T> current){
        return null;
    }


    //Busqueda de un elemento
    public T search(T x) throws ItemNotFound{
        Node<T> res = searchNode(x, this.root);

        if(res==null)
            throw new ItemNotFound("El dato "+x+" nose encuentra");
        return res.data;
    }
    public Node<T> searchNode(T x, Node<T> root){
        if(root==null) return null;
        else{
            int resC = root.data.compareTo(x);
            if(resC<0) return searchNode(x, root.right);
            else if(resC>0) return searchNode(x, root.left);
            else return root;
        }
    }
    
}

class ItemNotFound extends Exception {
    public ItemNotFound(String msg){
        super(msg);
    }
}
class ItemDuplicated extends Exception {
    public ItemDuplicated(String msg){
        super(msg);
    }
}

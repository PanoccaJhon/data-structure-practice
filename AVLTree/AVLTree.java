package AVLTree;
/**
 * @author Jhon Franklin Panocca Merma
 */
public class AVLTree<T extends Comparable<T>> {
    
    /**
     * Clase privada Node, nodo del arbol
     */
    private class Node<E>{
        Node<E> left, right;
        E data;
        int height;
        public Node(E data){
            this(data, null,null,0);
        }
        public Node(E data, Node<E> left, Node<E> right,int height){
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        } 

    }

    /**
     * Objeto raiz de arbol
     */
    private Node<T> root;

    /**
     * Constructor de clase AVLTree
     */
    public AVLTree(){
        this.root = null;
    }

    /**
     * Metodo para ver si el arbol esta vacio
     * @return
     */
    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * Metodo simple que devuelve el mayor valor de dos
     * entradas
     * @param left
     * @param right
     * @return maxim
     */
    private int getMaxHeight(int left, int right){
        return left>right?left:right;
    }
    
    /**
     * Metodo que devuelve la altura de un nodo
     * @param node
     * @return
     */
    private int getHeight(Node<T> node){
        return node==null? -1: node.height;
    }

    /**
     * Metodo para insertar un elemento al arbol
     * @param data
     */
    public void insert(T data){
        this.root = insert(data, this.root);
    }
    /**
     * Metodo para insertar un elemento al arbol,
     * requiere parametro adicional: raiz de arbol
     * @param data
     * @param root
     * @return
     */
    private Node<T> insert(T data, Node<T> root){

        if(root == null)
            return new Node<T>(data);
        else if(data.compareTo(root.data)<0){
            root.left = insert(data, root.left);
            if(getHeight(root.left) - getHeight(root.right) == 2){
                if(data.compareTo(root.left.data)<0)
                    root = rotateLeft(root);
                else
                    root = doubleRotateLeft(root);
            }
        }else if(data.compareTo(root.data)>0){
            root.right = insert(data, root.right);
            if(getHeight(root.right) - getHeight(root.left) == 2){
                if(data.compareTo(root.left.data)<0)
                    root = rotateRight(root);
                else
                    root = doubleRotateRight(root);
            }
        }else{
            root.height = getMaxHeight(getHeight(root.left), getHeight(root.right))+1;
        }
        return root;
    }

    /**
     * Rotacion simple con hijo iquierdo
     * @param node
     * @return
     */
    private Node<T> rotateLeft(Node<T> node){
        Node<T> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;

        node.height = getMaxHeight(getHeight(node.left), getHeight(node.right))+1;
        tmp.height = getMaxHeight(getHeight(tmp.left), getHeight(node))+1;
        
        return tmp;
    }
    /**
     * Rotacion doble con hijo derecho
     * @param node
     * @return
     */
    private Node<T> doubleRotateLeft(Node<T> node){
        node.left = rotateRight(node.left);
        return rotateLeft(node);
    }

    /**
     * Rotacion simple con hijo derecho
     * @param node
     * @return
     */
    private Node<T> rotateRight(Node<T> node){
        Node<T> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;

        node.height = getMaxHeight(getHeight(node.left), getHeight(node.right))+1;
        tmp.height = getMaxHeight(getHeight(tmp.right), getHeight(node))+1;
        
        return tmp;
    }
    /**
     * Rotación doble con hijo izquierdo
     * @param node
     * @return
     */
    private Node<T> doubleRotateRight(Node<T> node){
        node.right = rotateLeft(node.right);
        return rotateRight(node);
    }

    /**
     * Metodo que retorna el numero total de nodos
     * del arbol
     * @return
     */
    public int getNumberAllNodes(){
        return getNumberAllNodes(this.root);
    }

    /**
     * Metodo que retorna el numero total de nodos
     * del arbol, requiere un parametro de raiz de
     * arbol
     * @param root
     * @return
     */
    private int getNumberAllNodes(Node<T> root){
        if(root==null)
            return 0;
        else{
            int l = 1;
            l = l + getNumberAllNodes(root.left);
            l = l + getNumberAllNodes(root.right);
            return l;
        }
    }

    /**
     * Metodo para buscar un elemento en el arbol,
     * devuelve el verdadero si el elemento se encuentra
     * en el arbol, de lo contrario devuelve falso;
     * @param element
     * @return
     */
    public boolean search(T element){
        return search(element, this.root);
    }

    /**
     * Metodo para buscar un elemento en el arbol,
     * devuelve el verdadero si el elemento se encuentra
     * en el arbol, de lo contrario devuelve falso; 
     * requiere un parametro adicional: raiz de arbol
     * @param element
     * @param root
     * @return
     */
    private boolean search(T element, Node<T> root){
        boolean exists= false;
        while(root!=null && !exists){
            T root_value = root.data;
            if(element.compareTo(root_value)<0)
                root = root.left;
            else if(element.compareTo(root_value)>0)
                root = root.right;
            else{
                exists = true;
                break;
            }
            exists = search(element,root);
        }

        return exists;
    }

    /**
     * Metodo para eliminar un nodo del arbol
     * @param element
     */
    public void deleteNode(T element){
        this.root = deleteNode(element, this.root);
    }
    /**
     * Metodo para eliminar un nodo del arbol, 
     * requiere parametro: raiz
     * @param element
     * @param root
     * @return
     */
    private Node<T> deleteNode(T element, Node<T> root){
        if(element.compareTo(root.data) < 0)
            root.left = deleteNode(element, root.left);
        else if(element.compareTo(root.data)>0)
            root.right = deleteNode(element, root.right);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                Node<T> tmp = root;
                root = min(tmp.right);
                root.right = deleteMin(tmp.right);
                root.left = tmp.left;
            }
        }
        root.height = getMaxHeight(getHeight(root.left), getHeight(root.right))+1;
        return root;
    }

    /**
     * Devuelve el Nodo mas pequeño del arbol dado
     * @param root
     * @return
     */
    private Node<T> min(Node<T> root){
        if(root.left == null)
            return root;
        return min(root.left);
    }

    /**
     * Elimina el nodo mas bajo del arbol dado
     * @param root
     * @return
     */
    private Node<T> deleteMin(Node<T> root){
        if(root.left == null)
            return root.right;
        root.left = deleteMin(root.left);

        root.height = getMaxHeight(getHeight(root.left), getHeight(root.right))+1;

        return balance(root);
    }

    /**
     * Metodo que restaura la propiedad del arbol AVL
     * @param root
     * @return
     */
    private Node<T> balance(Node<T> root){
        if(balanceFactor(root) > 1){
            if(balanceFactor(root.right) < 0)
                root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }else if(balanceFactor(root) < -1){
            if(balanceFactor(root.left) > 0)
                root.left = rotateLeft(root.left);
            root = rotateRight(root);
        }
        return root;
    }

    /**
     * Retorna el factor de balance de un nodo
     * @param root
     * @return
     */
    private int balanceFactor(Node<T> root){
        return getHeight(root.right)-getHeight(root.left);
    }


    /**
     * Funcion que imprime el recorrido In Orden
     * en consola
     */
    public void inOrder(){
        inOrder(this.root);
    }
    private void inOrder(Node<T> root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+"("+balanceFactor(root)+") ");
            inOrder(root.right);
        }
    }

    /**
     * Funcion que imprime el recorrido Pre Orden
     * en consola
     */
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node<T> root){
        if(root!=null){
            System.out.print(root.data+"("+balanceFactor(root)+") ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * Funcion que imprime el recorrido Post Orden
     * en consola
     */
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(Node<T> root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+"("+balanceFactor(root)+") ");
        }
    }
}

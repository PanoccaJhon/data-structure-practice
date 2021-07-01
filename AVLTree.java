public class AVLTree<T extends Comparable<T>> {
    
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
     * Metodo para insertar un elemento al arbol
     * @param data
     */
    public void insert(T data){
        this.root = insert(data, this.root);
    }
    private Node<T> insert(T data, Node<T> root){

        if(root == null)
            return new Node<T>(data);
        else if(data.compareTo(root.data)<0){
            root.left = insert(data, root.left);
            if(root.left.height - root.right.height == 2){
                if(data.compareTo(root.left.data)<0)
                    root = rotateLeft(root);
                else
                    root = doubleRotateLeft(root);
            }
        }else if(data.compareTo(root.data)>0){
            root.right = insert(data, root.right);
            if(root.right.height - root.left.height == 2){
                if(data.compareTo(root.left.data)<0)
                    root = rotateRight(root);
                else
                    root = doubleRotateRight(root);
            }
        }else{
            root.height = getMaxHeight(root.left.height, root.right.height)+1;
        }
        return root;
    }

    /**
     * Rotacion simple con hijo iquierdo
     * @param node
     * @return
     */
    public Node<T> rotateLeft(Node<T> node){
        Node<T> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;

        node.height = getMaxHeight(node.left.height, node.right.height)+1;
        tmp.height = getMaxHeight(tmp.left.height, node.height)+1;
        
        return tmp;
    }
    /**
     * Rotacion doble con hijo derecho
     * @param node
     * @return
     */
    public Node<T> doubleRotateLeft(Node<T> node){
        node.left = rotateRight(node.left);
        return rotateLeft(node);
    }

    /**
     * Rotacion simple con hijo derecho
     * @param node
     * @return
     */
    public Node<T> rotateRight(Node<T> node){
        Node<T> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;

        node.height = getMaxHeight(node.left.height, node.right.height)+1;
        tmp.height = getMaxHeight(tmp.right.height, node.height)+1;
        
        return tmp;
    }
    /**
     * Rotación doble con hijo izquierdo
     * @param node
     * @return
     */
    public Node<T> doubleRotateRight(Node<T> node){
        node.right = rotateLeft(node.right);
        return rotateRight(node);
    }
}

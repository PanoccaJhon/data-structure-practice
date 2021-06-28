public class BinaryTree<E extends Comparable<E>> {
    // clase Node
    public class Node{
        Node left, right;
        E value;

        public Node(){
            this(null,null);
        }
        public Node(Node lchild, Node rchild){
            this(null, lchild, rchild);
        }
        public Node(E value, Node lchild, Node rchild){
            this.value = value;
            this.left = lchild;
            this.right = rchild;
        }
        public boolean isLeaf(){
            return left==null&&right==null;
        }
    }

    //Raiz de árbol
    private Node root;

    // Constructor
    public BinaryTree(){
        this.root = null;
    }

    //Recorridos en arbol:

    public void preOrder(){
        /**
         * Implemantación de recorrido Pre-Orden: raiz, izquierda, derecha
         */
    }
    public void inOrden(){
        /**
         * Implementación de recorrido In-Orden: izquierda, raiz, derecha
         */
    }
    public void postOrder(){
        /**
         * Implementación de recorrido Post-Orden: izquierda, derecha, raiz
         */
    }
}

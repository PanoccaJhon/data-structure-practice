package RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> {
    private class Node<E>{
        public E data;
        public boolean isRed;
        public Node<E> left;
        public Node<E> right;

        public Node(E data){
            this.data = data;
            this.isRed = true;
            this.left = null;
            this.right = null;
        }

    }

    private Node<T> root;

    public RedBlackTree(){
        this.root = null;
    }

    // INSERTAR UN ELEMENTO

    public boolean insert(T data){
        try{
            this.root = insert(data, this.root);
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
            return false;
        }

        return true;
    }

    private Node<T> insert(T data, Node<T> node) throws IllegalArgumentException{
        /**
         * Implementar algoritmo aqui.
         */
        if(data == null)
            throw new IllegalArgumentException("El dato no debe ser nulo");
        
        if(node == null){
            node = new Node<T>(data);
        }else if(data.compareTo(node.left.data)<0){
            node.left = insert(data, node.left);
        }else if(data.compareTo(node.right.data)>0){
            
        }else{
            throw new IllegalArgumentException("El dato ya existe");
        }

        return node;
    }

    // ELIMINAR UN ELEMENTO

    // CONSULTAR UN ELEMENTO
}

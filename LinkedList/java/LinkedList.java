package LinkedList.java;

/**
 * @author Jhon Franklin Panocca Merma
 */
public class LinkedList<T extends Comparable<T>> {
    
    /**
     * Clase privada que representa el nodo de
     * la estructura
     */
    private class Node<E>{
        public E value;         //Valor que se almacena en el Nodo
        public Node<E> next;    //Puntero hacia el sigueinte elemento de la lista

        public Node(E value){
            this.value = value;
            this.next = null;
        }
    }

    // ATRIBUTOS DE LA ESTRUCTURA:

    private Node<T> root;       //Objeto del tipo Node que representa la raiz de la estructura


    //CONSTRUCTOR

    public LinkedList(){
        this.root = null;
    }


    // GETTERS AND SETTERS

    /**
     * Método público que permite agregar un nuevo valor a la estructura, hace
     * uso de un método privado que hace la acción de agregar.
     * @param new_value Valor de tipo generico que sera ingresado a la estructura
     */
    public void insert(T new_value){
        this.root = add(this.root, -1, new_value, -1);
    }
    /**
     * Método público que permite agregar un nuevo valor a la estructura, hace
     * uso de un método privado que hace la acción de agregar.
     * @param new_value Valor de tipo generico que sera ingresado a la estructura
     */
    public void insert(int index, T new_value){
        this.root = add(this.root, index, new_value, 0);
    }

    /**
     * Método privado que agrega un valor a la estructura.
     * @param node Nodo puntero donde se realiza la operación.
     * @param index Valor entero que representa la posicion a insertar, si es -1 inserta el neuvo valor al final de la estructura.
     * @param new_value Valor a insertar en la estructura.
     * @param n Valor entero que representa en indice del Nodo actual.
     * @return Retorna un objeto de tipo Node con su valor insertado o no, dependiendo del caso.
     */
    private Node<T> add(Node<T> node, int index, T new_value, int n){
        
        if (index != -1) {
            if (index == n){ 
                Node<T> new_node = new Node<T>(new_value);
                new_node.next = node;
                return new_node;
            }else
                node.next = add(node.next,index,new_value,n+1);
            
        }else{
            if (node == null) 
                return new Node<T>(new_value);
            else
                node.next = add(node.next,index,new_value,n+1);
            
        }
        return node;
    }

    /**
     * 
     * @param index
     * @return  Retorna un objeto generico con el valor buscado, si no encuentra una coinsidencia, es nulo
     */
    public T getValue(int index){
        return getValue(this.root, index);
    }

    /**
     * 
     * @param node
     * @param index
     * @return
     */
    private T getValue(Node<T> node, int index){
        Node<T> temp = node;
        for (int i = 0; temp != null; i++) {
            if (index == i) 
                return temp.value;
            temp = temp.next;
        }
        return null;
    }

    public boolean search(T value){
        return search(this.root, value);
    }
    private boolean search(Node<T> node, T value){
        boolean exist = false;
        Node<T> temp = node;
        while (temp != null) {
            if (temp.value.compareTo(value)==0){
                exist = true;
                break;
            }
            temp = temp.next; 
        }
        return exist;
    }

    /**
     * Método para eliminar un elemento de la estructura, hace uso de otro método
     * privado
     * @param  index Indice del valor a eliminar
     */
    public void remove(int index){
        this.root = remove(this.root, index, 0);
    }

    /**
     * Métoso privado que elimina un valor de la estructura, 
     * @param node  Nodo sobre el cual se trabaja
     * @param index Indice que indica el elemento a eliminar
     * @param n     Indice del nodo sobre el cual se esta trabajando
     * @return      Retorna el nodo modificado o no, dependiendo el caso
     */
    private Node<T> remove(Node<T> node, int index, int n){
        if (index == n)
            return node.next;
        else
            node.next = remove(node.next, index, n+1);
        return node;
    }

    /**
     * Metodo que imprime en consola una lista de todos los datos almacenados en la estructura
     */
    public void printList(){
        String list = "";
        Node<T> tmp = this.root;
        while (tmp != null) {
            list = list + tmp.value.toString();
            tmp = tmp.next;
        }

        System.out.println(">>> "+list);
    }
}

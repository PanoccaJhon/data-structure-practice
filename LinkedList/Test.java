package LinkedList;

public class Test {
    public static void main(String[] args) {
        /**
         * En este apartado se haran las pruebas de linked list
         */

        LinkedList<Integer> mi_lista = new LinkedList<Integer>();

        mi_lista.insert(2);
        mi_lista.insert(3);
        mi_lista.insert(4);
        mi_lista.insert(5);
        mi_lista.insert(6);

        mi_lista.insert(2,8);

        mi_lista.printList();

        
    }
}
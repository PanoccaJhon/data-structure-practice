package LinkedList.java;

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

        System.out.println("Lista luego de insertar datos:");
        mi_lista.printList();

        System.out.println("Lista luego de inserción con index:");
        mi_lista.insert(2,8);
        mi_lista.printList();

        System.out.println("Lista luego de eliminar el primer valor:");
        mi_lista.remove(0);
        mi_lista.printList();

        System.out.println("el valor en el puesto 3 es: ");
        System.out.println(">>> "+mi_lista.getValue(3-2));

        
    }
}
package AVLTree;

import java.util.Scanner;

/**
 * Test
 * @author Jhon Franklin Panocca Merma
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Bienvenido:");
        // testAVL();

        ejerciciosDos();
    }
    public static void ejerciciosDos(){
        AVLTree<Integer> t1 = new AVLTree<Integer>();
        AVLTree<Integer> t2 = new AVLTree<Integer>();
        AVLTree<Integer> t3 = new AVLTree<Integer>();
        AVLTree<Integer> t4 = new AVLTree<Integer>();

        int[] data1 = {44,70,30,2,72,26,81,55};
        int[] data2 = {80,95,66,70,98,67};
        int[] data3 = {80,40,60,120,100,30,130,140,125,150,20,15};
        int[] data4 = {14,1,6,17,8,9};

        for (int i = 0; i < data1.length; i++) {
            t1.insert(data1[i]);
        }
        for (int i = 0; i < data2.length; i++) {
            t2.insert(data2[i]);
        }
        for (int i = 0; i < data3.length; i++) {
            t3.insert(data3[i]);
        }
        for (int i = 0; i < data4.length; i++) {
            t4.insert(data4[i]);
        }

        System.out.println("Ejercicio 2:\nRECORRIDOS DE ARBOLES: IN-ORDEN");
        System.out.println("\n\nAVL1: ");
        t1.inOrder();
        System.out.println("\n\nAVL2: ");
        t2.inOrder();
        System.out.println("\n\nAVL3: ");
        t3.inOrder();
        System.out.println("\nAVL4: ");
        t4.inOrder();

        System.out.println("\n\nEjercio 4: eliminar 100 en AVL 3");
        t3.deleteNode(100);
        t3.inOrder();
    }

    public static void testAVL(){
        AVLTree<Integer> obj = new AVLTree<Integer>();   
        Scanner sc = new Scanner(System.in);
        char choice;    
        do      
        {  
            System.out.println("\nSelecciona una operación:\n");  
            System.out.println("1. Insertar");  
            System.out.println("2. Buscar");  
            System.out.println("3. Numero total de nodos");  
            System.out.println("4. Esta vacio?");  
            System.out.println("5. Eliminar");  
            System.out.println("6. Imprimir recorridos"); 
   
            int ch = sc.nextInt();              
            switch (ch)  
            {  
                case 1 :   
                    System.out.println("Ingresa un elemento a ingresar");  
                    obj.insert( sc.nextInt() );                       
                    break;                            
                case 2 :   
                    System.out.println("Ingrese una elemento a buscar");  
                    System.out.println(obj.search( sc.nextInt() ));  
                    break;                                            
                case 3 :   
                    System.out.println(obj.getNumberAllNodes());  
                    break;       
                case 4 :   
                    System.out.println(obj.isEmpty());  
                    break;       
                case 5 :   
                    System.out.println("Ingresar un elemento a eliminar");
                    int x = sc.nextInt();
                    obj.deleteNode(x);   
                    break;  
                case 6 :   
                    System.out.println("\nRecorridos del arbol");  
                    System.out.println("\nIn Orden");
                    obj.inOrder();
                    System.out.println("\nPre Orden");
                    obj.preOrder();
                    System.out.println("\nPost Orden");
                    obj.postOrder(); 
                    break;  
                default :   
                    System.out.println("\n ");  
                    break;      
            }  
            System.out.println("\nIngrese \"y\" o \"n\" para continuar\n");  
            choice = sc.next().charAt(0);                          
        } while (choice == 'Y'|| choice == 'y');    
        sc.close();      
    }
}
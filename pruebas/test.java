package pruebas;

import java.util.Scanner;

/**
 * @author Jhon Franklin Panocca Merma
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese cantidad de numeros:");
        int n = sc.nextInt();

        System.out.println("Entrada de numero:");
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("El numero mayor es:");
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= m) {
                m = nums[i];
            }
        }
    }

    public static int max(int a, int b){
        return a >= b? a : b;
    }
}
package pruebas;

//import java.util.Scanner;

/**
 * @author Jhon Franklin Panocca Merma
 */
public class test {
    public static void main(String[] args) {
        int a[] = {1,2,4,3,6};
        System.out.println(function(a));
    }

    public static boolean function(int[] x){
        int c[] = {0,0};
        for (int i = 0; i < x.length; i++) {
            if (x[i]==1) {
                c[0] = 1;
            }
            if (x[i] ==4) {
                c[1] = 1;
            }
            if (c[0]==1 && c[1] == 1) {
                return false;
            }
            
        }
        return true;
    }
}
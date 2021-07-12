package PatternMatching;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        
        String text = "I love programming and i do programming";
        System.out.println(text);
        
        System.out.println("Enter a pattern to found in text:");
        String pattern = sc.next();

        int position = PatternMatching.bruteForce(text,pattern);
        int endindex = position+1;

        if(position == -1)
            System.out.println("Pattern is not match");
        else
            System.out.println("Patten found at position:"+endindex);
        sc.close();
    }
}
import java.util.*;

public class PrintNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();

        String numStr = Integer.toString(n);
        for (int i = 0; i < numStr.length(); i++) {
            System.out.println(numStr.charAt(i));
        }
    }
}

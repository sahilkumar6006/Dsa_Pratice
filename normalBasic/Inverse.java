package normalBasic;

import java.util.Scanner;

public class Inverse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = scn.nextInt();

        int inverse =0;
        int originialpos = 1;
        while (n != 0) {
            int od = n % 10;
            int ip =od;

            inverse = inverse + ip * (int)(Math.pow(10, originialpos - 1));
            n = n/ 10;
            originialpos++;
            
        }
        System.out.println("The inverse of the number is: " + inverse);
    }
}

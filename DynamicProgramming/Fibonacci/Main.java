package Fibonacci;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(n);
        int fibonacci = fib(n, new int[n + 1]);
        System.out.println(fibonacci);
    }

    public static int fib(int n, int qb []) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (qb[n] != 0) {
          return qb[n];
      }

        qb[n] = fib(n - 1, qb) + fib(n - 2 , qb);
        return qb[n];
    }
}

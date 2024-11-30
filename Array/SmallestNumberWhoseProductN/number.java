package Array.SmallestNumberWhoseProductN;
import java.util.*;

public class number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(solution(n));
        
    }

    public static int solution(int n){
        String ans = "";
        for(int div =9; div >=2; div--){
            while(n % div == 0){
                n = n/ div;
                ans = div +ans;

            }
        }
        if (n !=1) {
            return -1;
        }else {
            return Integer.parseInt(ans);
        }
    }
}

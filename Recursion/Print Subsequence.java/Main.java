import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String output = "";
        printSS(input, output);
    }


    public static void printSS(String input, String output){

        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        char ch = input.charAt(0);
        printSS(input.substring(1), output + ch);

        printSS(input.substring(1), output);
    }
}

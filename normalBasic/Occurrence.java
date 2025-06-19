package normalBasic;

public class Occurrence {
    public static void main(String[] args) {
        int[] arr = {35, 47, 47, 56, 65};
        int j = 0;

        // Removing duplicates in a sorted array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i]; // Overwrite duplicates
            }
        }

        // Print unique elements
        for (int k = 0; k <= j; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}

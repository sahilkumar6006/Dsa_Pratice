public class RBS {
    public static void main(String[] args) {
        
    }

    static int findPivot(int[] arr){
        int start =0;
        int end = arr.length =1;

        while( start <= end){
           int mid = start + (end - start) / 2;

            //4 cases
            if(arr[mid] > arr[mid+1]){
                return mid;
            }
        }
    }
}

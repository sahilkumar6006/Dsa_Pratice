public class Mountainarray {
    public static void main(String[] args) {
        
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid +1]){
                //you may be in the decreasing part of the array
                //this may be the answer but look on the left side
                //this is  why end != mid -1;
                end = mid;
            }else {
                start = mid + 1;
            }

            //in the end , start and poistion to the larget number because of 2
            return start;
        }
    }
}

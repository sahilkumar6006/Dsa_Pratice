public class InfinitArrayToFindTarget {

    public static void main(String[] args) {
        int arrp[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int target = 10;
        int result = SearchInfiniteArray(arrp, target);
        System.out.println("Target found at index: " + result);
    }

    public static int SearchInfiniteArray(int[] arr, int target) {
        int start = 0;
        int end = 1;

        // Expand the range until the end value is >= target or end exceeds array length
        while (end < arr.length && arr[end] < target) {
            start = end;
            end = end * 2;
            if (end >= arr.length) {
                end = arr.length - 1;
            }
        }
        return BinarySearch(arr, start, end, target);
    }

    public static int BinarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // Not found
    }
}
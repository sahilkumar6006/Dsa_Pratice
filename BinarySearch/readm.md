## Binary Search Theory

Binary Search is an efficient algorithm for finding an item from a sorted list of elements. It works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, the algorithm narrows the interval to the lower half. Otherwise, it narrows it to the upper half. This process continues until the value is found or the interval is empty. Binary Search has a time complexity of O(log n).

---

## LeetCode Question: Peak Index in a Mountain Array

**Problem:**  
Given a mountain array `arr`, return the peak index in the array.  
A mountain array is defined as an array where:

- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
    - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

**LeetCode Link:** [Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

**Binary Search Approach:**  
Since the array increases and then decreases, you can use binary search to find the peak efficiently:

```java
public int peakIndexInMountainArray(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if (arr[mid] < arr[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
```
## Binary Search Theory

Binary Search is an efficient algorithm for finding an item in a sorted list. It works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle, the interval is narrowed to the lower half; otherwise, to the upper half. This continues until the value is found or the interval is empty.

- **Time Complexity:** O(log n)

---

## LeetCode: Peak Index in a Mountain Array

**Problem:**  
Given a mountain array `arr`, return the peak index.  
A mountain array is defined as:

- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
    - `arr[0] < arr[1] < ... < arr[i]`
    - `arr[i] > arr[i+1] > ... > arr[arr.length-1]`

**[LeetCode Link](https://leetcode.com/problems/peak-index-in-a-mountain-array/)**

**Binary Search Approach:**

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

---
## Ceiling of a Number in a Sorted Array

> **Ceiling** of a number is the smallest element in a sorted array that is **greater than or equal to** the target value.

---

### 📌 Definition

Given a sorted array `arr` and a target value `target`, the **ceiling** is the smallest `arr[i]` such that `arr[i] >= target`.  
If no such element exists, return `-1`.

---

### 🧠 Example

```text
arr    = [2, 3, 5, 9, 14, 16, 18]
target = 15

Ceiling of 15 is 16
Ceiling of 18 is 18
Ceiling of 20 does not exist → return -1
```

---

### ⚡ Approach: Binary Search

Since the array is sorted, we can efficiently find the ceiling using binary search.

#### Steps

1. Initialize `start = 0`, `end = n - 1`
2. While `start <= end`:
    - Compute `mid = start + (end - start) / 2`
    - If `arr[mid] == target`, return `arr[mid]` (perfect match)
    - If `arr[mid] < target`, search right half (`start = mid + 1`)
    - Else, search left half (`end = mid - 1`)
3. After the loop, `start` points to the smallest number ≥ target
4. If `start < arr.length`, return `arr[start]`; else, return `-1`

---

### 💻 Java Implementation

```java
public static int ceiling(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return arr[mid]; // perfect match
        }

        if (arr[mid] < target) {
            start = mid + 1; // go right
        } else {
            end = mid - 1; // go left
        }
    }

    // start is now at the ceiling position
    if (start < arr.length) {
        return arr[start];
    }
    return -1; // ceiling doesn't exist
}
```

---

### 🔍 Dry Run

Let's find the ceiling of `15` in `[2, 3, 5, 9, 14, 16, 18]`:

| Step | start | end | mid | arr[mid] | Action                |
| ---- | ----- | --- | --- | -------- | --------------------- |
| 1    | 0     | 6   | 3   | 9        | arr[mid] < 15 → right |
| 2    | 4     | 6   | 5   | 16       | arr[mid] > 15 → left  |
| 3    | 4     | 4   | 4   | 14       | arr[mid] < 15 → right |

- Loop ends, `start = 5`, so `arr[5] = 16` is the ceiling.

---

### 📝 Summary

- Use binary search for efficiency.
- Return `arr[start]` if `start < arr.length`.
- If not found, return `-1`.

---

## Rotated Sorted Array Search

### Problem Statement

Given a sorted array rotated at some pivot, search for a target value.  
Return its index if found, else return -1.

**Example:**  
```
Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0  
Output: 4
```
(The original sorted array was `[0, 1, 2, 4, 5, 6, 7]`.)

---

### Approach: Modified Binary Search

Even after rotation, at least one half of the array remains sorted at every step.  
We use this property to decide which half to search next.

#### Steps

1. Initialize `left = 0`, `right = n - 1`
2. While `left <= right`:
    - Find `mid = (left + right) / 2`
    - If `nums[mid] == target`, return `mid`
    - Check which half is sorted:
        - If `nums[left] <= nums[mid]` (left half sorted):
            - If `nums[left] <= target < nums[mid]`, search left half (`right = mid - 1`)
            - Else, search right half (`left = mid + 1`)
        - Else (right half sorted):
            - If `nums[mid] < target <= nums[right]`, search right half (`left = mid + 1`)
            - Else, search left half (`right = mid - 1`)
3. If not found, return -1

#### Java Code

```java
public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target)
            return mid;
        // Left half sorted
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // Right half sorted
        else {
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
```

---

### Dry Run Example

**Input:**  
`nums = [4, 5, 6, 7, 0, 1, 2]`, `target = 0`

| Iteration | left | mid | right | nums[mid] | Action              |
| --------- | ---- | --- | ----- | --------- | ------------------- |
| 1         | 0    | 3   | 6     | 7         | Right half (left=4) |
| 2         | 4    | 5   | 6     | 1         | Left half (right=4) |
| 3         | 4    | 4   | 4     | 0         | Found at index 4    |

#### Step-by-step:

1. `left=0`, `right=6`, `mid=3` (`nums[mid]=7`)
    - Left half `[4,5,6,7]` is sorted.
    - Target `0` not in left half, search right (`left=4`)
2. `left=4`, `right=6`, `mid=5` (`nums[mid]=1`)
    - Left half `[0,1]` is sorted.
    - Target `0` is in left half, search left (`right=4`)
3. `left=4`, `right=4`, `mid=4` (`nums[mid]=0`)
    - Found target at index 4.

---

### Intuition Behind the Approach

- **Why check `nums[left] <= nums[mid]`?**  
  To determine if the left half is sorted. If true, check if the target lies within this half.
- **If not, the right half must be sorted.**  
  Similarly, check if the target lies within the right half.

**Visual Example:**  
For `[6, 7, 8, 1, 2, 3, 4]` (rotated `[1, 2, 3, 4, 6, 7, 8]`):

- If `nums[left] <= nums[mid]` is false, right half is sorted.

**Quick Rules:**

| Condition                           | Meaning                |
| ----------------------------------- | ---------------------- |
| `nums[left] <= nums[mid]`           | Left side sorted       |
| `nums[mid] < target <= nums[right]` | Target in right sorted |
| `nums[left] <= target < nums[mid]`  | Target in left sorted  |

---

**Summary:**  
At every step, at least one half is sorted. Use this to decide which half to search, and apply binary search accordingly.


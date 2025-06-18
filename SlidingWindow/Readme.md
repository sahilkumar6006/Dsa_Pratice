# Sliding Window Technique

The **sliding window technique** is a powerful and efficient method for solving problems involving arrays or strings, especially when you need to:

- Find substrings or subarrays of a given length
- Calculate max/min/sum/count of elements in a range

---

## 🧠 Basic Idea

Instead of checking every possible subarray (which is typically O(n²)), use a "window" that slides over the data (usually left to right), keeping track of useful information (like sum, frequency, etc.).

---

## ✅ When to Use Sliding Window

- When the problem asks for subarrays/substrings of a fixed or variable size
- When you need contiguous elements
- When brute-force is too slow

---

## 🔹 Types of Sliding Window

- **Fixed-size window**
- **Variable-size window (dynamic)**

---

## 📌 1. Fixed-Size Window Example

**Problem:** Find the max sum of a subarray of size `k`.

```java
public int maxSum(int[] arr, int k) {
    int windowSum = 0;
    int maxSum = 0;

    // First window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;

    // Slide the window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```

---

## 📌 2. Variable-Size Window Example

**Problem:** Longest substring without repeating characters ([LeetCode #3](https://leetcode.com/problems/longest-substring-without-repeating-characters/))

```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

---

## 🚀 Advantages

- Reduces time complexity from **O(n²)** to **O(n)**
- Very useful in interview problems

---

*Would you like to practice a sliding window problem right now with a Java solution and explanation?*
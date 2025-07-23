1. **What the Code Solves:**

This code solves the problem of finding the **first and last occurrence (indices) of a target element in a sorted array** efficiently using binary search.

2. **Problem Description:**

Given a sorted array of integers (in non-decreasing order) and a target integer, find the starting and ending position of the target value in the array. If the target is not present in the array, return [-1, -1]. This problem is widely encountered in coding interviews and competitive programming to test understanding of binary search variations and edge-case handling. Efficiently finding the first and last positions allows quick frequency queries and subarray operations.

3. **Examples:**

Example 1:
- Input: arr = [2, 4, 4, 4, 5, 6, 7], target = 4
- Output: [1, 3]
Explanation: The element 4 appears first at index 1 and last at index 3.

Example 2:
- Input: arr = [1, 2, 3, 5, 6], target = 4
- Output: [-1, -1]
Explanation: 4 is not present in the array.

Example 3 (Edge case):
- Input: arr = [], target = 1
- Output: [-1, -1]
Explanation: Empty array means target cannot be found.

4. **Logic Explanation:**

- Use a modified binary search twice: once to find the **first occurrence** of the target and once to find the **last occurrence**.
- For **first occurrence**:
  - Initialize start = 0, end = n-1.
  - While start <= end:
    - Compute mid.
    - If arr[mid] == key, update answer to mid, but continue search on the left half to find earlier occurrences (end = mid - 1).
    - If arr[mid] < key, search right half (start = mid + 1).
    - Else search left half (end = mid - 1).
- For **last occurrence**:
  - Same as above except when arr[mid] == key, search in the right half (start = mid + 1) to find later occurrences.
- Return pair(firstOccurrence, lastOccurrence).
- If target not found, both return -1.
- **Time Complexity:** O(log n) because each binary search runs in logarithmic time.
- **Optimization/Gotchas:** Avoid integer overflow in mid calculation by using mid = start + (end - start)/2.

5. **Java Conversion with Comments:**

public class FirstAndLastPositionFinder {

    /**
     * Finds the first occurrence of key in sorted array arr.
     * @param arr Sorted integer array
     * @param key Target value
     * @return Index of first occurrence or -1 if not found
     */
    private static int firstOccurrence(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                ans = mid;          // Potential answer found
                end = mid - 1;      // Move left to find earlier occurrence
            } else if (arr[mid] < key) {
                start = mid + 1;    // Move right
            } else {
                end = mid - 1;      // Move left
            }
        }
        return ans;
    }

    /**
     * Finds the last occurrence of key in sorted array arr.
     * @param arr Sorted integer array
     * @param key Target value
     * @return Index of last occurrence or -1 if not found
     */
    private static int lastOccurrence(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                ans = mid;          // Potential answer found
                start = mid + 1;    // Move right to find later occurrence
            } else if (arr[mid] < key) {
                start = mid + 1;    // Move right
            } else {
                end = mid - 1;      // Move left
            }
        }
        return ans;
    }

    /**
     * Returns the first and last positions of key in arr.
     * @param arr Sorted integer array
     * @param key Target value
     * @return int array of size 2: [first occurrence, last occurrence]
     */
    public static int[] findFirstAndLastPosition(int[] arr, int key) {
        int first = firstOccurrence(arr, key);
        int last = lastOccurrence(arr, key);
        return new int[]{first, last};
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        int[] arr1 = {2,4,4,4,5,6,7};
        int key1 = 4;
        int[] res1 = findFirstAndLastPosition(arr1, key1);
        System.out.println("First and last positions of " + key1 + " are: [" + res1 + ", " + res1[1] + "]");

        int[] arr2 = {1,2,3,5,6};
        int key2 = 4;
        int[] res2 = findFirstAndLastPosition(arr2, key2);
        System.out.println("First and last positions of " + key2 + " are: [" + res2 + ", " + res2[1] + "]");
    }
}
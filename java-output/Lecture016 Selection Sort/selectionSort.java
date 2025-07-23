1. **What the Code Solves:**

The provided C++ code implements the **Selection Sort** algorithm, which is a classic sorting technique in data structures and algorithms.

2. **Problem Description:**

**Selection Sort Problem:**  
Given an array (or list) of integers, sort the array in ascending order by repeatedly finding the minimum element from the unsorted portion and swapping it with the first unsorted element, until the entire array is sorted.

**Context:**  
Sorting is a fundamental problem in computer science with applications ranging from database query optimization to organizing data for efficient searching. Selection Sort is often introduced as a simple sorting technique in educational settings and is sometimes used in scenarios with small datasets or where simplicity of implementation is crucial.

3. **Examples:**

Example 1 (Typical Case):  
Input: [64, 25, 12, 22, 11]  
Output: [11, 12, 22, 25, 64]  

Example 2 (Edge Case - Already Sorted):  
Input: [1, 2, 3, 4, 5]  
Output: [1, 2, 3, 4, 5]  

4. **Solution Logic:**

- Iterate over the array from the first element to the second last element (index i from 0 to n-2).
- Assume the current element at index i is the minimum (minIndex = i).
- Scan the rest of the array (index j from i+1 to n-1) to find any element smaller than the current minimum.
- If a smaller element is found, update minIndex to that element’s index.
- After scanning, swap the element at i with the element at minIndex to place the smallest element in its correct sorted position.
- Repeat until the entire array is sorted.

**Techniques and Patterns:**
- This is a simple greedy approach ensuring minimum selection in each iteration.
- No recursion or complex data structures used.
- The algorithm is in-place sorting (no extra array needed).

**Time Complexity:**  
- O(n²), where n is the number of elements, due to nested loops scanning the array.

**Optimization/Gotchas:**  
- Selection Sort always performs O(n²) comparisons even on sorted input, so it’s inefficient for large data.
- It performs a minimal number of swaps (at most n-1), which can be useful when write operations are costly.

5. **Java Conversion:**

public class SelectionSort {

    /**
     * Sorts the input array using the selection sort algorithm.
     * @param arr integer array to be sorted in ascending order
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Move boundary of unsorted subarray from 0 to n-1
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the minimum element in unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Main method to demonstrate usage with example inputs
    public static void main(String[] args) {
        int[] example1 = {64, 25, 12, 22, 11};
        selectionSort(example1);
        System.out.print("Sorted array example1: ");
        for (int num : example1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] example2 = {1, 2, 3, 4, 5};
        selectionSort(example2);
        System.out.print("Sorted array example2: ");
        for (int num : example2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
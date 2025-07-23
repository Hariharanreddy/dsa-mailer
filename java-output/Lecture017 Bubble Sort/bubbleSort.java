1. **What the Code Solves:**

The given C++ code implements the **Bubble Sort algorithm**, which is a classic sorting algorithm in Data Structures and Algorithms (DSA).

2. **Problem Description:**

**Problem Statement:**  
Given an array of integers, sort the array in non-decreasing order using the Bubble Sort algorithm. Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order. This process continues until the entire array is sorted.

This problem is fundamental in understanding sorting algorithms, their basic mechanism, and the concept of optimization by early stopping if the array becomes sorted before completing all passes. Bubble Sort is often taught in introductory DSA and appears in coding exercises and interview prep to illustrate sorting logic and algorithm optimization.

3. **Examples:**

**Example 1:**  
Input: [5, 2, 8, 6, 3]  
Output: [2, 3, 5, 6, 8]

**Example 2 (Edge Case - Already Sorted Array):**  
Input: [1, 2, 3, 4, 5]  
Output: [1, 2, 3, 4, 5]  
(Note: The algorithm will detect this early and stop unnecessary iterations.)

4. **Logic Explanation in Points:**

- The algorithm performs multiple passes (rounds) through the array.  
- In each pass, it iterates through the unsorted part of the array and compares adjacent elements.  
- If the current element is greater than the next, the two are swapped to push the larger value towards the end (like a bubble rising to the surface).  
- A boolean `swapped` flag tracks if any swap happened in a pass.  
- If no swaps occur in a pass, the array is already sorted, and the algorithm stops early to optimize performance.  
- This process repeats for `n-1` passes or until early stopping.  
- **Time Complexity:** Worst case O(n²), Best case O(n) if array is already sorted due to early stopping.

5. **Java Code Conversion:**  

public class BubbleSortExample {
    /**
     * Performs bubble sort on the input array.
     * @param arr The array of integers to sort.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            boolean swapped = false;
            
            // Last i elements are already in place
            for (int j = 0; j < n - i; j++) {
                // Swap if current element is greater than next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                }
            }
            
            // If no swaps occurred, array is sorted and we can exit early
            if (!swapped) {
                break;
            }
        }
    }

    // Main method for testing the bubble sort implementation
    public static void main(String[] args) {
        int[] example1 = {5, 2, 8, 6, 3};
        bubbleSort(example1);
        System.out.print("Sorted Example 1: ");
        for (int num : example1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] example2 = {1, 2, 3, 4, 5};
        bubbleSort(example2);
        System.out.print("Sorted Example 2 (already sorted): ");
        for (int num : example2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
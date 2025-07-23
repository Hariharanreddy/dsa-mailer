## Explanation of What the Code Solves

The **core DSA problem** addressed is **finding the unique element in an array where every other element is repeated twice**. This leverages the property of the XOR (bitwise exclusive OR) operation, a classic technique for such problems due to the way XOR cancels out pairs of numbers.

## Problem Statement

Given an array of integers where every element appears **twice except for one** which appears **once**, identify the unique element.

**Context:**  
This problem is common in competitive programming and technical interviews. It tests your understanding of bitwise operations and is often used as a warm-up for bit manipulation puzzles. In real-world scenarios, similar logic can help detect anomalies or identify non-duplicate entries in datasets.

## Examples

**Example 1:**
```
Input:     [2, 3, 4, 2, 3]
Output:    4
```

**Example 2:**
```
Input:     [7, 9, 7, 9, 4, 5, 5]
Output:    4
```

Both examples show that **all elements except one appear twice, and the goal is to find the unique one**.

## Logic Breakdown

- **Bitwise XOR Basics:**  
  XOR returns 0 for two equal numbers and cancels itself when applied twice.
- **Algorithm Steps:**
  1. Initialize `ans` to 0.
  2. Iterate through the array.
  3. For each element, `ans = ans XOR element`.
  4. At the end, `ans` contains the unique element because all pairs cancel out, leaving only the unique one.
- **Time Complexity:**  
  \(O(n)\)—just a single pass through the array.
- **Optimizations/Gotchas:**  
  This is already optimal: no extra space, linear time.
  **Key gotcha:** The array must have exactly one unique element and all others appear **exactly twice**. If there are multiple uniques or odd counts, the solution no longer works.
- **Underlying Pattern:**  
  **Bit manipulation**, particularly the **XOR property** for pair cancellation.

## Java Conversion

```java
public class UniqueElementFinder {
    // Finds the single unique element in an array where every other element appears twice.
    public static int findUnique(int[] arr) {
        int ans = 0;
        for (int num : arr) {
            ans ^= num;  // XOR each element; duplicates will cancel out
        }
        return ans;
    }

    // Demonstration and testing in main()
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {2, 3, 4, 2, 3};
        System.out.println("Input: " + java.util.Arrays.toString(arr1));
        System.out.println("Unique element: " + findUnique(arr1));

        // Example 2
        int[] arr2 = {7, 9, 7, 9, 4, 5, 5};
        System.out.println("Input: " + java.util.Arrays.toString(arr2));
        System.out.println("Unique element: " + findUnique(arr2));
    }
}
```

- **Comments** are included for clarity and best-practice documentation.
- **Method signature** uses array directly, matching typical Java style.
- **Main method** demonstrates use with the previous examples.
- **Good practices** like static method, clear variable naming, and simple I/O are followed.
1. **What the Code Solves:**  
This code solves the "Next Smaller Element to the Right" problem using a stack.

2. **Problem Description:**  
Given an array of integers, for each element find the next smaller element to its right in the array. If there is no smaller element to the right, return -1 for that element. This problem is common in data structures and algorithms interviews and competitive programming because it demonstrates how to efficiently use a stack to solve array lookup problems in linear time.

3. **Examples:**

Example 1:  
Input: [4, 5, 2, 10, 8]  
Output: [2, 2, -1, 8, -1]  
Explanation:  
- Next smaller for 4 is 2.  
- Next smaller for 5 is 2.  
- 2 has no smaller element to its right → -1.  
- Next smaller for 10 is 8.  
- 8 has no smaller element → -1.

Example 2 (Edge case):  
Input: [1, 2, 3, 4, 5]  
Output: [-1, -1, -1, -1, -1]  
Explanation: Elements are in ascending order, so no smaller element exists to the right for any element.

4. **Explanation of the Logic:**

- Use a stack to keep track of candidate next smaller elements as we traverse the array from right to left.
- Initialize the stack with -1 to indicate when no smaller element exists.
- For each element starting from the end:
  - While the stack's top is greater than or equal to the current element, pop from the stack because those elements can't be the next smaller for the current element or any to the left.
  - The element currently at the top of the stack is the next smaller element for the current element.
  - Push the current element onto the stack to become a potential next smaller for elements to the left.
- This approach ensures each element is pushed and popped at most once, resulting in O(n) time complexity.
- The space complexity is O(n) due to the stack and output array.

5. **Java Code Conversion:**

public class NextSmallerElement {

    /** 
     * Finds the next smaller element to the right for each element in the array.
     * If no such element exists, -1 is placed for that position.
     */
    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(-1); // Sentinel value for no smaller element

        // Traverse array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            // Pop elements from stack that are not smaller than current
            while (stack.peek() >= curr) {
                stack.pop();
            }
            // The top element now is the next smaller to the right
            ans[i] = stack.peek();
            // Push current element for next iterations
            stack.push(curr);
        }
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] input1 = {4, 5, 2, 10, 8};
        int[] output1 = nextSmallerElement(input1);
        System.out.println(java.util.Arrays.toString(output1)); // Expected: [2, 2, -1, 8, -1]

        int[] input2 = {1, 2, 3, 4, 5};
        int[] output2 = nextSmallerElement(input2);
        System.out.println(java.util.Arrays.toString(output2)); // Expected: [-1, -1, -1, -1, -1]
    }
}
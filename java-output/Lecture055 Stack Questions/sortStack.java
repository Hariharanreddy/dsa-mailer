1. **What the Code Solves:**
The given C++ code implements an algorithm to **sort a stack using recursion**, without using any additional data structures.

2. **Problem Description:**
You are given a stack of integers. Your task is to sort this stack such that the smallest elements are on the top of the stack. You should accomplish this using only the basic stack operations — push, pop, top (peek), and isEmpty — and **without using any extra data structures like arrays or additional stacks**. 

This problem is a classic example of using **recursion and stack manipulation** to perform sorting. It appears in many coding interviews and competitive programming due to its algorithmic elegance and constraints on data structure usage.

3. **Examples:**

Example 1  
Input stack (top to bottom):  [3, 1, 4, 2]  
Output stack (top to bottom): [1, 2, 3, 4]  

Example 2 (Edge case — already sorted)  
Input stack (top to bottom):  [1, 2, 3, 4]  
Output stack (top to bottom): [1, 2, 3, 4]  

Example 3 (Edge case — descending order)  
Input stack (top to bottom):  [4, 3, 2, 1]  
Output stack (top to bottom): [1, 2, 3, 4]  

4. **Explanation of the Logic:**

- The algorithm uses **two functions**: `sortStack` and `sortedInsert`.

- `sortStack` recursively pops elements from the top of the stack until the stack is empty (base case).

- Once the stack is empty, it begins inserting the elements back in sorted order using `sortedInsert`.

- The `sortedInsert` function places the top element `num` in the correct sorted position within the stack. It does this by recursively popping elements that are smaller than `num`, inserting `num` in the correct position, then pushing back the popped elements.

- This approach leverages recursion both for **breaking down the problem** (emptying the stack) and for the **insertion logic** (placing the element in sorted order).

- The key pattern is **recursive sorting with controlled insertion on a constrained data structure (stack)**.

- **Time Complexity:** \(O(n^2)\) in the worst case, since for each element insertion, in the worst case, you might have to pop almost all elements.

5. **Java Code Implementation:**

public class SortStackRecursive {
    // Inserts 'num' into the sorted stack so that smallest elements are on top
    private static void sortedInsert(java.util.Stack<Integer> stack, int num) {
        // Base case: stack empty or top element smaller than num
        if (stack.isEmpty() || stack.peek() < num) {
            stack.push(num);
            return;
        }
        
        // Remove the top element and recur
        int top = stack.pop();
        sortedInsert(stack, num);
        
        // Push the top back after inserting num
        stack.push(top);
    }
    
    // Recursively sorts the stack
    public static void sortStack(java.util.Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        // Remove top element and sort remaining stack
        int top = stack.pop();
        sortStack(stack);
        
        // Insert the removed element back in sorted order
        sortedInsert(stack, top);
    }
    
    // Helper method to print stack from top to bottom
    public static void printStack(java.util.Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        
        System.out.println("Original stack (top to bottom):");
        printStack(stack);
        
        sortStack(stack);
        
        System.out.println("Sorted stack (top to bottom):");
        printStack(stack);
    }
}
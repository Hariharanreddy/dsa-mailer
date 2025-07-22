import java.util.Stack;

class Solution {
    // Recursive function to delete the middle element of a stack
    private void solve(Stack<Integer> inputStack, int count, int size) {
        // Base case: If half the elements have been processed, pop the top element
        if (count == size / 2) {
            inputStack.pop();
            return;
        }

        // Store the top element
        int num = inputStack.peek();
        // Remove the top element
        inputStack.pop();

        // Recursive call to process the remaining elements
        solve(inputStack, count + 1, size);

        // Push the stored element back onto the stack
        inputStack.push(num);
    }

    // Function to delete the middle element of a stack
    public void deleteMiddle(Stack<Integer> inputStack, int N) {
        int count = 0;
        solve(inputStack, count, N);
    }
}

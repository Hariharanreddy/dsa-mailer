import java.util.Stack;

class Solution {
    // Recursive function to insert x at the bottom of the stack
    private void solve(Stack<Integer> s, int x) {
        // Base case: if stack is empty, push x and return
        if (s.isEmpty()) {
            s.push(x);
            return;
        }

        // Store the top element
        int num = s.pop();

        // Recursive call to insert x at the bottom
        solve(s, x);

        // Push the stored element back onto the stack
        s.push(num);
    }

    // Function to push an element x at the bottom of the stack
    public Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        solve(myStack, x);
        return myStack;
    }
}

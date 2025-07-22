import java.util.Stack;

class Solution {
    //Inserts an element into the stack in a sorted manner.
    public void sortedInsert(Stack<Integer> stack, int num) {
        //Base case: If the stack is empty or the top element is smaller than num
        if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() < num) ) {
            stack.push(num);
            return;
        }

        int n = stack.peek();
        stack.pop();

        //Recursive call
        sortedInsert(stack, num);

        stack.push(n);
    }

    //Sorts the stack using recursion.
    public void sortStack(Stack<Integer> stack) {
        //Base case: If the stack is empty
        if(stack.isEmpty()) {
            return;
        }

        int num = stack.peek();
        stack.pop();

        //Recursive call
        sortStack(stack);

        sortedInsert(stack, num);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack: " + stack);

        sol.sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

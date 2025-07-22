import java.util.Stack;

class Solution {
    //Inserts an element at the bottom of the stack
    public void insertAtBottom(Stack<Integer> s, int element) {
        //Base case: if stack is empty, push the element
        if(s.isEmpty()) {
            s.push(element);
            return;
        }
        
        int num = s.peek(); //Get the top element
        s.pop(); //Remove the top element

        //Recursive call to insert at the bottom
        insertAtBottom(s, element);
        
        s.push(num); //Push the removed element back
    }

    //Reverses the stack using recursion
    public void reverseStack(Stack<Integer> stack) {
        //Base case: if stack is empty, return
        if(stack.isEmpty()) {
            return;
        }
        
        int num = stack.peek(); //Get the top element
        stack.pop(); //Remove the top element

        //Recursive call to reverse the remaining stack
        reverseStack(stack);
        
        insertAtBottom(stack, num); //Insert the removed element at the bottom
    }
}

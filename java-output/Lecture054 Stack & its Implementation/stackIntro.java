```java
import java.util.EmptyStackException;

class Stack {
    // Properties
    private int[] arr;
    private int top;
    private int size;

    // Constructor
    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    // Push operation
    public void push(int element) {
        if (size - top > 1) {
            top++;
            arr[top] = element;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Pop operation
    public void pop() {
        if (top >= 0) {
            top--;
        } else {
            System.out.println("Stack Underflow");
        }
    }

    // Peek operation
    public int peek() {
        if (top >= 0) {
            return arr[top];
        } else {
            System.out.println("Stack is Empty");
            return -1; // Or throw an exception
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack st = new Stack(5);

        st.push(22);
        st.push(43);
        st.push(44);
        st.push(22);
        st.push(43);
        st.push(44); //this will cause overflow

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.peek());

        if (st.isEmpty()) {
            System.out.println("Stack is Empty mere dost");
        } else {
            System.out.println("Stack is not Empty mere dost");
        }
    }
}
```

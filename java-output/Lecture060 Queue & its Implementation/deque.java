1. **What the Code Solves:**

This code implements a **Deque (Double-Ended Queue)** data structure using a circular array. It supports insertion and deletion operations from both the front and rear ends efficiently.

2. **Problem Description:**

Design and implement a **Deque** supporting the following operations on a fixed-size buffer:

- `pushFront(x)`: Insert element `x` at the front of the deque.
- `pushRear(x)`: Insert element `x` at the rear of the deque.
- `popFront()`: Remove and return the element from the front. Return -1 if deque is empty.
- `popRear()`: Remove and return the element from the rear. Return -1 if deque is empty.
- `getFront()`: Return front element without removing it, or -1 if empty.
- `getRear()`: Return rear element without removing it, or -1 if empty.
- `isEmpty()`: Check if deque is empty.
- `isFull()`: Check if deque is full.

The deque should work optimally using constant time operations, with the backing storage as a fixed-size circular buffer (array).

**Context and relevance:**  
Deques are widely used in systems programming, task schedulers, and algorithms where double-ended access is needed, such as sliding window problems in competitive programming. Implementing them using circular arrays is a common technique to achieve efficient memory usage and O(1) time complexity for operations.

3. **Examples:**

Example 1 (Normal usage):  
Input operations:  
pushRear(5), pushFront(3), getFront(), getRear(), popFront(), popRear()  

Output:  
3 (front element)  
5 (rear element)  
3 (popped from front)  
5 (popped from rear)  

Example 2 (Edge case - Empty and Full):  
Initial deque size = 3  
Operations:  
popFront() -> -1 (empty)  
pushRear(1), pushRear(2), pushFront(3) -> true  
isFull() -> true  
pushRear(4) -> false (cannot push, full)  
popRear() -> 2  

4. **Explanation of Logic:**

- Uses a fixed-size array `arr` to store elements.
- Maintains two indices: `front` and `rear`, to mark front and rear positions.
- When empty, `front` and `rear` are -1.
- For insertion:
  - If deque empty, set `front = rear = 0`.
  - Else, `pushFront` moves front backward circularly; `pushRear` moves rear forward circularly.
- For removal:
  - `popFront` moves front forward circularly.
  - `popRear` moves rear backward circularly.
- Circular movement is done using modulo arithmetic to wrap around the array ends.
- `isFull` condition checks if the circular queue is filled (front next to rear).
- `isEmpty` checks if `front == -1`.
  
**Technique:** Circular array implementation of deque results in O(1) amortized time for all operations without dynamic memory allocation during runtime.

**Time complexity:**  
- All operations (`pushFront`, `pushRear`, `popFront`, `popRear`, `getFront`, `getRear`) take **O(1)** time.
- Space complexity is O(n) for array of size n.

5. **Java Code:**

public class Deque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize deque of size n
    public Deque(int n) {
        size = n;
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if deque is full
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == (rear + 1) % size);
    }

    // Insert an element at front
    public boolean pushFront(int x) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1; // wrap around
        } else {
            front--;
        }
        arr[front] = x;
        return true;
    }

    // Insert an element at rear
    public boolean pushRear(int x) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0; // wrap around
        } else {
            rear++;
        }
        arr[rear] = x;
        return true;
    }

    // Remove and return element from front
    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        int val = arr[front];
        arr[front] = -1; // optional: clear slot for debugging

        if (front == rear) {
            // Only one element was present
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0; // wrap around
        } else {
            front++;
        }
        return val;
    }

    // Remove and return element from rear
    public int popRear() {
        if (isEmpty()) {
            return -1;
        }
        int val = arr[rear];
        arr[rear] = -1; // optional

        if (front == rear) {
            // Only one element was present
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1; // wrap around
        } else {
            rear--;
        }
        return val;
    }

    // Peek front element
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    // Peek rear element
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

    // Optional: main method to demonstrate usage
    public static void main(String[] args) {
        Deque deque = new Deque(3);

        System.out.println(deque.popFront()); // -1 empty

        System.out.println(deque.pushRear(1)); // true
        System.out.println(deque.pushRear(2)); // true
        System.out.println(deque.pushFront(3)); // true

        System.out.println(deque.isFull()); // true

        System.out.println(deque.pushRear(4)); // false

        System.out.println(deque.popRear()); // 2
        System.out.println(deque.getFront()); // 3
        System.out.println(deque.getRear());  // 1
    }
}
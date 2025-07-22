import java.util.Arrays;

class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    // Initialize your data structure.
    public CircularQueue(int n) {
        size = n;
        arr = new int[size];
        front = rear = -1;
    }

    // Enqueues 'X' into the queue. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean enqueue(int value) {
        //to check whether queue is full
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            //System.out.println("Queue is Full");
            return false;
        } else if (front == -1) //first element to push
        {
            front = rear = 0;

        } else if (rear == size - 1 && front != 0) {
            rear = 0; //to maintain cyclic nature
        } else {
            //normal flow
            rear++;
        }
        //push inside the queue
        arr[rear] = value;

        return true;
    }

    // Dequeues top element from queue. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int dequeue() {
        if (front == -1) {//to check queue is empty
            //System.out.println("Queue is Empty ");
            return -1;
        }
        int ans = arr[front];
        arr[front] = -1;
        if (front == rear) { //single element is present
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0; //to maintain cyclic nature
        } else {
            //normal flow
            front++;
        }
        return ans;
    }
}

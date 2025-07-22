import java.util.*;
class Queue {

    private int[] arr;
    private int qfront;
    private int rear;
    private int size;

    //Constructor to initialize the queue
    public Queue() {
        size = 100001;
        arr = new int[size];
        qfront = 0;
        rear = 0;
    }

    //Check if the queue is empty
    public boolean isEmpty() {
        return qfront == rear;
    }

    //Add an element to the rear of the queue
    public void enqueue(int data) {
        if (rear == size) {
            System.out.println("Queue is Full");
        } else {
            arr[rear] = data;
            rear++;
        }
    }

    //Remove and return the element at the front of the queue
    public int dequeue() {
        if (qfront == rear) {
            return -1;
        } else {
            int ans = arr[qfront];
            arr[qfront] = -1; // Mark as removed
            qfront++;
            if (qfront == rear) {
                qfront = 0;
                rear = 0;
            }
            return ans;
        }
    }

    //Return the element at the front of the queue without removing it
    public int front() {
        if (qfront == rear) {
            return -1;
        } else {
            return arr[qfront];
        }
    }
}

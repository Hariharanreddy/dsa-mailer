import java.util.Arrays;

class kQueue {

    int n;
    int k;
    int[] front;
    int[] rear;
    int[] arr;
    int freeSpot;
    int[] next;

    public kQueue(int n, int k) {
        this.n = n;
        this.k = k;
        front = new int[k];
        rear = new int[k];
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);

        next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        arr = new int[n];
        freeSpot = 0;
    }

    public void enqueue(int data, int qn) {
        //overflow
        if (freeSpot == -1) {
            System.out.println("No Empty space is present");
            return;
        }

        //find first free index
        int index = freeSpot;

        //update freespot
        freeSpot = next[index];

        //check whether first element
        if (front[qn - 1] == -1) {
            front[qn - 1] = index;
        } else {
            //link new element to the prev element
            next[rear[qn - 1]] = index;
        }

        //update next
        next[index] = -1;

        //update rear
        rear[qn - 1] = index;

        //push element
        arr[index] = data;
    }

    public int dequeue(int qn) {
        //underflow 
        if (front[qn - 1] == -1) {
            System.out.println("Queue UnderFlow ");
            return -1;
        }

        //find index to pop
        int index = front[qn - 1];

        //front ko aage badhao
        front[qn - 1] = next[index];

        //freeSlots ko manage karo
        next[index] = freeSpot;
        freeSpot = index;
        return arr[index];
    }

}

public class Main {
    public static void main(String[] args) {
        kQueue q = new kQueue(10, 3);
        q.enqueue(10, 1);
        q.enqueue(15, 1);
        q.enqueue(20, 2);
        q.enqueue(25, 1);

        System.out.println(q.dequeue(1));
        System.out.println(q.dequeue(2));
        System.out.println(q.dequeue(1));
        System.out.println(q.dequeue(1));

        System.out.println(q.dequeue(1));
    }
}

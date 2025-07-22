import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

public class DSADemo {
    public static void main(String[] args) {
        System.out.println((-1) % 1); //Modulo operation
        Deque<Integer> d = new ArrayDeque<>(); //Using ArrayDeque as a deque

        d.addFirst(12); //push_front in C++
        d.addLast(14);  //push_back in C++

        System.out.println(d.getFirst()); //front in C++
        System.out.println(d.getLast());  //back in C++

        d.removeFirst(); //pop_front in C++

        System.out.println(d.getFirst()); //front in C++
        System.out.println(d.getLast());  //back in C++
        d.removeLast(); //pop_back in C++

        if (d.isEmpty()) {
            System.out.println("queue is empty");
        } else {
            System.out.println("queue is not empty");
        }

        //Commented out section from C++ code.  This section uses a queue instead of a deque.
        /*
        Queue<Integer> q = new LinkedList<>(); //Using LinkedList as a queue

        q.add(11);
        System.out.println("front of q is: " + q.peek());
        q.add(15);
        System.out.println("front of q is: " + q.peek());

        q.add(13);
        System.out.println("front of q is: " + q.peek());

        System.out.println("size of queue is : " + q.size());

        q.remove();
        q.remove();
        q.remove();

        System.out.println("size of queue is : " + q.size());

        if (q.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("queue is not empty");
        }
        */
    }
}

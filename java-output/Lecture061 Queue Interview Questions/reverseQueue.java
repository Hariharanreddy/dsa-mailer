import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueReverser {

    /**
     * Reverses the elements of a queue using a stack.
     * @param q The input queue.
     * @return The reversed queue.
     */
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        // Move all elements from the queue to the stack
        while (!q.isEmpty()) {
            int element = q.poll(); //Removes and returns the head of the queue
            s.push(element);
        }

        // Move all elements from the stack back to the queue
        while (!s.isEmpty()) {
            int element = s.pop();
            q.offer(element); //Adds the specified element to the end of this queue.
        }
        return q;
    }
}

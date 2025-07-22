```java
import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    // Constructor
    Node(int d) {
        this.data = d;
        this.next = null;
    }

    @Override
    protected void finalize() throws Throwable {
        int value = this.data;
        if (this.next != null) {
            next = null;
        }
        System.out.println("Memory is free for node with data " + value);
        super.finalize();
    }
}

public class CircularLinkedList {

    // Insert a node after a given element
    static void insertNode(Node tail, int element, int d) {
        // Empty list
        if (tail == null) {
            Node newNode = new Node(d);
            tail = newNode;
            newNode.next = newNode;
        } else {
            // Non-empty list
            // Assuming that the element is present in the list
            Node curr = tail;
            while (curr.data != element) {
                curr = curr.next;
            }
            // Element found - curr is representing element wala node
            Node temp = new Node(d);
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    // Print the linked list
    static void print(Node tail) {
        Node temp = tail;
        // Empty list
        if (tail == null) {
            System.out.println("List is Empty");
            return;
        }
        do {
            System.out.print(tail.data + " ");
            tail = tail.next;
        } while (tail != temp);
        System.out.println();
    }

    // Delete a node with a given value
    static void deleteNode(Node tail, int value) {
        // Empty list
        if (tail == null) {
            System.out.println("List is empty, please check again");
            return;
        } else {
            // Non-empty
            // Assuming that "value" is present in the Linked List
            Node prev = tail;
            Node curr = prev.next;
            while (curr.data != value) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            // 1 Node Linked List
            if (curr == prev) {
                tail = null;
            }
            // >=2 Node linked list
            else if (tail == curr) {
                tail = prev;
            }
            curr.next = null;
            //curr = null; //This is handled by garbage collection in java.
        }
    }

    // Check if the linked list is circular
    static boolean isCircularList(Node head) {
        // Empty list
        if (head == null) {
            return true;
        }
        Node temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }
        if (temp == head) {
            return true;
        }
        return false;
    }

    // Detect loop using a map
    static boolean detectLoop(Node head) {
        if (head == null)
            return false;
        Map<Node, Boolean> visited = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            // Cycle is present
            if (visited.containsKey(temp)) {
                return true;
            }
            visited.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node tail = null;

        if (isCircularList(tail)) {
            System.out.println("Linked List is Circular in nature");
        } else {
            System.out.println("Linked List is not Circular");
        }
    }
}
```

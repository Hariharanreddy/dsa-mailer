```java
class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Destructor (Finalizer in Java) - not explicitly called, garbage collection handles it
    @Override
    protected void finalize() throws Throwable {
        int value = this.data;
        // Memory free (handled by garbage collection)
        if (this.next != null) {
            // Java's garbage collection handles memory deallocation
        }
        System.out.println("Memory is free for node with data " + value);
        super.finalize();
    }
}

public class LinkedList {

    //Insert at the beginning of the linked list.
    public static void insertAtHead(Node head, int d) {
        Node temp = new Node(d);
        temp.next = head;
        head = temp;
    }

    //Insert at the end of the linked list.
    public static void insertAtTail(Node tail, int d) {
        Node temp = new Node(d);
        tail.next = temp;
        tail = temp;

    }

    // Print the linked list.
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Insert at a specific position.
    public static void insertAtPosition(Node tail, Node head, int position, int d) {
        if (position == 1) {
            insertAtHead(head, d);
            return;
        }
        Node temp = head;
        int cnt = 1;
        while (cnt < position - 1) {
            temp = temp.next;
            cnt++;
        }
        if (temp.next == null) {
            insertAtTail(tail, d);
            return;
        }
        Node nodeToInsert = new Node(d);
        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;
    }

    // Delete a node at a specific position.
    public static void deleteNode(int position, Node head) {
        if (position == 1) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            //Memory free start node, handled by GC
        } else {
            Node curr = head;
            Node prev = null;
            int cnt = 1;
            while (cnt < position) {
                prev = curr;
                curr = curr.next;
                cnt++;
            }
            prev.next = curr.next;
            curr.next = null;
            //Memory free curr node, handled by GC

        }
    }

    public static void main(String[] args) {
        // Example usage (add your own test cases here)
    }
}
```

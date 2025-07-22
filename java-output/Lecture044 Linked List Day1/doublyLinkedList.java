import java.util.NoSuchElementException;

class Node {
    int data;
    Node prev;
    Node next;

    // Constructor
    Node(int d) {
        this.data = d;
        this.prev = null;
        this.next = null;
    }

    @Override
    protected void finalize() throws Throwable {
        int val = this.data;
        if (next != null) {
            next = null; // Dereference to allow garbage collection
        }
        System.out.println("Memory free for node with data " + val);
        super.finalize();
    }
}

public class DoublyLinkedList {

    // Traversing a linked list
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Gives length of Linked List
    static int getLength(Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    // Insert at the head of the list
    static void insertAtHead(Node tail, Node head, int d) {
        // Empty list
        if (head == null) {
            Node temp = new Node(d);
            head = temp;
            tail = temp;
        } else {
            Node temp = new Node(d);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    // Insert at the tail of the list
    static void insertAtTail(Node tail, Node head, int d) {
        if (tail == null) {
            Node temp = new Node(d);
            tail = temp;
            head = temp;
        } else {
            Node temp = new Node(d);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    // Insert at a given position
    static void insertAtPosition(Node tail, Node head, int position, int d) {
        // Insert at the start
        if (position == 1) {
            insertAtHead(tail, head, d);
            return;
        }

        Node temp = head;
        int cnt = 1;

        while (cnt < position - 1) {
            temp = temp.next;
            cnt++;
            if(temp == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
        }

        // Inserting at the last position
        if (temp.next == null) {
            insertAtTail(tail, head, d);
            return;
        }

        // Creating a node for d
        Node nodeToInsert = new Node(d);

        nodeToInsert.next = temp.next;
        temp.next.prev = nodeToInsert;
        temp.next = nodeToInsert;
        nodeToInsert.prev = temp;
    }


    static void deleteNode(int position, Node head) {
        //Deleting the first node
        if (position == 1) {
            if(head == null) {
                throw new NoSuchElementException("Cannot delete from an empty list");
            }
            Node temp = head;
            if(temp.next != null) {
                temp.next.prev = null;
                head = temp.next;
                temp.next = null;
            } else {
                head = null;
            }
            
        } else {
            // Deleting any middle node or last node
            Node curr = head;
            Node prev = null;
            int cnt = 1;
            while (cnt < position) {
                prev = curr;
                curr = curr.next;
                cnt++;
                if(curr == null) {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
            }
            if(prev != null) {
                prev.next = curr.next;
            }
            if(curr.next != null) {
                curr.next.prev = prev;
            }

        }
    }

    public static void main(String[] args) {
        Node head = null;
        Node tail = null;

        print(head);
        //System.out.println(getLength(head));

        insertAtHead(tail, head, 11);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtHead(tail, head, 13);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtHead(tail, head, 8);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtTail(tail, head, 25);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtPosition(tail, head, 2, 100);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtPosition(tail, head, 1, 101);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtPosition(tail, head, 7, 102);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        deleteNode(7, head);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        //Example of exception handling
        try {
            deleteNode(10, head);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }
}

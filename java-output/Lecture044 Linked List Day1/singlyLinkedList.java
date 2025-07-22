```java
import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Destructor (Not directly implemented in Java, garbage collection handles it)
    @Override
    protected void finalize() throws Throwable {
        int value = this.data;
        // Memory free (handled by garbage collection)
        if (this.next != null) {
            this.next = null; // Help garbage collection
        }
        System.out.println("Memory is free for node with data " + value);
        super.finalize();
    }
}

public class LinkedList {

    // Insert at the head of the linked list
    static void insertAtHead(Node head, int d) {
        Node temp = new Node(d);
        temp.next = head;
        // Update the head reference
        head = temp;
    }

    // Insert at the tail of the linked list
    static void insertAtTail(Node tail, int d) {
        Node temp = new Node(d);
        tail.next = temp;
        // Update tail reference
        tail = temp;
    }

    // Print the linked list
    static void print(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Insert a node at a given position
    static void insertAtPosition(Node tail, Node head, int position, int d) {
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

    // Delete a node at a given position
    static void deleteNode(int position, Node head) {
        if (position == 1) {
            Node temp = head;
            head = head.next;
            temp.next = null; // Help garbage collection
            return;
        }
        Node curr = head;
        Node prev = null;
        int cnt = 1;
        while (cnt < position) {
            prev = curr;
            curr = curr.next;
            cnt++;
        }
        prev.next = curr.next;
        curr.next = null; // Help garbage collection
    }

    // Check if the linked list is circular
    static boolean isCircularList(Node head) {
        if (head == null) {
            return true; // Empty list is considered circular
        }
        Node temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }
        return temp == head;
    }

    // Detect loop using a map
    static boolean detectLoop(Node head) {
        if (head == null) return false;
        Map<Node, Boolean> visited = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (visited.get(temp) != null && visited.get(temp)) {
                System.out.println("Present on element " + temp.data);
                return true;
            }
            visited.put(temp, true);
            temp = temp.next;
        }
        return false;
    }


    // Floyd's cycle-finding algorithm
    static Node floydDetectLoop(Node head) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (slow == fast) {
                System.out.println("Present at " + slow.data);
                return slow;
            }
        }
        return null;
    }

    // Find the starting node of the loop
    static Node getStartingNode(Node head) {
        if (head == null) return null;
        Node intersection = floydDetectLoop(head);
        Node slow = head;
        while (slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }
        return slow;
    }

    // Remove the loop from the linked list
    static void removeLoop(Node head) {
        if (head == null) return;
        Node startOfLoop = getStartingNode(head);
        Node temp = startOfLoop;
        while (temp.next != startOfLoop) {
            temp = temp.next;
        }
        temp.next = null;
    }


    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node head = node1;
        Node tail = node1;

        insertAtTail(tail, 12);
        insertAtTail(tail, 15);
        insertAtPosition(tail, head, 4, 22);

        tail.next = head.next;

        System.out.println("head " + head.data);
        System.out.println("tail " + tail.data);


        if (floydDetectLoop(head) != null) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("no cycle");
        }

        Node loop = getStartingNode(head);
        System.out.println("loop starts at " + loop.data);

        removeLoop(head);
        print(head);
    }
}
```

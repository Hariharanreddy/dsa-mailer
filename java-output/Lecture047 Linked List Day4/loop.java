```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    // Function to detect loop in a linked list using Floyd's cycle-finding algorithm
    Node floydDetectLoop(Node head) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            slow = slow.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    // Function to find the starting node of the loop
    Node getStartingNode(Node head) {
        if (head == null)
            return null;

        Node intersection = floydDetectLoop(head);

        if (intersection == null)
            return null;

        Node slow = head;

        while (slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }

        return slow;
    }

    // Function to remove the loop from a linked list
    Node removeLoop(Node head) {
        if (head == null)
            return null;

        Node startOfLoop = getStartingNode(head);

        if (startOfLoop == null)
            return head;

        Node temp = startOfLoop;

        while (temp.next != startOfLoop) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; //creating a loop

        System.out.println("Original List:");
        list.printList(head);
        list.removeLoop(head);
        System.out.println("\nList after removing loop:");
        list.printList(head);

    }

    void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
```

```java
class Node {
    int data;
    Node next;
    Node arb;

    Node(int d) {
        data = d;
        next = null;
        arb = null;
    }
}

class Solution {
    private void insertAtTail(Node head, Node tail, int d) { //Note: head and tail are passed by reference implicitly in java.
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    private void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private void printRandom(Node head) {
        while (head != null) {
            System.out.print(" head data: " + head.data + " ");
            if (head.arb != null) {
                System.out.print(" head random data" + head.arb.data);
            } else {
                System.out.print(" head random data: NULL");
            }
            head = head.next;
            System.out.println();
        }
    }

    public Node copyList(Node head) {
        // step 1: Create a Clone List
        Node cloneHead = null;
        Node cloneTail = null;

        Node temp = head;
        while (temp != null) {
            insertAtTail(cloneHead, cloneTail, temp.data);
            temp = temp.next;
        }

        // step 2: insert nodes of Clone List in between originalList

        Node originalNode = head;
        Node cloneNode = cloneHead;

        while (originalNode != null && cloneNode != null) {
            Node next = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = next;

            next = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = next;
        }

        // step 3: Random pointer copy
        originalNode = head;
        cloneNode = cloneHead;

        while (originalNode != null && cloneNode != null) {

            if (originalNode.arb != null) {
                cloneNode.arb = originalNode.arb.next;
            } else {
                cloneNode.arb = null;
            }

            cloneNode = cloneNode.next;
            originalNode = originalNode.next;
        }

        // step 4: revert step 2 changes
        originalNode = head;
        cloneNode = cloneHead;

        while (originalNode != null && cloneNode != null) {
            originalNode.next = originalNode.next != null ? originalNode.next.next : originalNode.next;
            cloneNode.next = cloneNode.next != null ? cloneNode.next.next : cloneNode.next;
            originalNode = originalNode.next;
            cloneNode = cloneNode.next;
        }

        // step 5 answer return
        return cloneHead;
    }
}
```

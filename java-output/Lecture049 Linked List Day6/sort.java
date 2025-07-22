```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    //Inserts a node at the tail of the list
    void insertAtTail(Node tail, Node curr) {
        tail.next = curr;
        //update tail
        tail = curr;
    }

    Node sortList(Node head) {
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node curr = head;

        // create separate lists for 0s, 1s, and 2s
        while (curr != null) {
            int value = curr.data;

            if (value == 0) {
                zeroTail.next = curr;
                zeroTail = curr;
            } else if (value == 1) {
                oneTail.next = curr;
                oneTail = curr;
            } else if (value == 2) {
                twoTail.next = curr;
                twoTail = curr;
            }
            curr = curr.next;
        }

        // merge the three sublists
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        oneTail.next = twoHead.next;
        twoTail.next = null;

        // set the head of the sorted list
        head = zeroHead.next;

        //Not deleting dummy nodes as Java's garbage collector handles it automatically

        return head;
    }
}
```

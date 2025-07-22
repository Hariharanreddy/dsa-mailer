import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers.
     *
     * @param head The head of the linked list.
     * @return The head of the modified linked list with duplicates removed.
     */
    Node uniqueSortedList(Node head) {
        //empty List
        if (head == null)
            return null;

        //non empty list
        Node curr = head;

        while (curr != null) {

            if ((curr.next != null) && curr.data == curr.next.data) {
                Node next_next = curr.next.next;
                Node nodeToDelete = curr.next;
                curr.next = next_next; //Remove the node
            } else //not equal
            {
                curr = curr.next;
            }
        }

        return head;
    }
}

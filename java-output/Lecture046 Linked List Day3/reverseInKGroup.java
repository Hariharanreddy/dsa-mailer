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
    // Function to reverse the first k nodes of the linked list.
    Node kReverse(Node head, int k) {
        // Base case: If the list is empty or k is 0, return the head.
        if (head == null || k == 0) {
            return head;
        }

        // Step 1: Reverse the first k nodes.
        Node next = null;
        Node curr = head;
        Node prev = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 2: Recursively reverse the remaining list.
        if (next != null) {
            head.next = kReverse(next, k);
        }

        // Step 3: Return the head of the reversed list.
        return prev;
    }
}

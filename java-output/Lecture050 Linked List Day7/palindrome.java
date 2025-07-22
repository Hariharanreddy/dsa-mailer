import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(Node head) {
        if (head.next == null) {
            return true;
        }

        // step 1 -> find Middle
        Node middle = getMid(head);
        // System.out.println("Middle " + middle.data);

        // step 2 -> reverse List after Middle
        Node temp = middle.next;
        middle.next = reverse(temp);

        // step 3 - Compare both halves
        Node head1 = head;
        Node head2 = middle.next;

        while (head2 != null) {
            if (head2.data != head1.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        // step 4 - repeat step 2
        temp = middle.next;
        middle.next = reverse(temp);

        return true;
    }
}

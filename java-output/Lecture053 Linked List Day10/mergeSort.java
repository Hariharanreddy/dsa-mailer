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
    // Function to find the middle of the linked list
    Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted linked lists
    Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node ans = new Node(-1);
        Node temp = ans;

        // Merge two sorted linked lists
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        while (left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }

        while (right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }

        ans = ans.next;
        return ans;
    }

    // Function to sort the linked list using merge sort
    Node mergeSort(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Break linked list into two halves, after finding mid
        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // Recursive calls to sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge both left and right halves
        Node result = merge(left, right);
        return result;
    }
}
```

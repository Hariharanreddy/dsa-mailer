1. **What the Code Solves:**

The given code solves the problem of **removing duplicates from a sorted singly linked list**, resulting in a linked list containing only unique elements.

2. **Problem Description:**

*Given a singly linked list where the elements are sorted in non-decreasing order, remove all duplicate nodes such that each element appears exactly once. You need to modify the linked list in-place and return the head of the updated list.*

This problem commonly appears in interview preparation and competitive programming contexts because it tests a candidate’s ability to manipulate linked lists efficiently, manage pointers/references correctly, and optimize operations for sorted data structures.

3. **Examples:**

Example 1 (Typical Case):  
Input: 1 -> 1 -> 2 -> 3 -> 3  
Output: 1 -> 2 -> 3  

Explanation: Duplicate 1’s and 3’s are removed.

Example 2 (Edge Case - All Elements Same):  
Input: 5 -> 5 -> 5 -> 5  
Output: 5  

Explanation: All duplicates removed, only one instance remains.

4. **Logic Explanation:**

- Start from the head of the list.
- While traversing the list:
  - Compare the current node’s value with the next node’s value.
  - If they are the same, remove the next node by linking the current node to the node after the next, and free the duplicate node.
  - If they are different, move the current pointer forward.
- Continue until you reach the end of the list (null).
- Return the modified head of the list with unique elements.
- This approach is efficient because the list is sorted; duplicates are adjacent.
- **Time complexity**: O(N), where N is the number of nodes, since we traverse the list once.
- **Space complexity**: O(1), as no extra space is used.

5. **Java Code Implementation:**

public class UniqueSortedList {
    
    // Node class representing each element in the singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Removes duplicates from a sorted linked list
    public static Node uniqueSortedList(Node head) {
        if (head == null) {
            return null; // empty list
        }

        Node curr = head;

        while (curr != null && curr.next != null) {
            // If current node and next node have the same value,
            // skip the next node to remove duplicate
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next; // move forward only if no duplicate
            }
        }
        return head;
    }

    // Utility method to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Example usage and testing
    public static void main(String[] args) {
        // Example 1: 1->1->2->3->3
        Node head1 = new Node(1);
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(3);
        System.out.print("Original list: ");
        printList(head1);
        head1 = uniqueSortedList(head1);
        System.out.print("List after removing duplicates: ");
        printList(head1);

        // Example 2: 5->5->5->5
        Node head2 = new Node(5);
        head2.next = new Node(5);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(5);
        System.out.print("Original list: ");
        printList(head2);
        head2 = uniqueSortedList(head2);
        System.out.print("List after removing duplicates: ");
        printList(head2);
    }
}
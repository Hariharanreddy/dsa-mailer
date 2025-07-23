1. **What the Code Solves:**

The code solves the **"Clone a Linked List with Next and Random Pointer"** problem. This involves creating a deep copy of a linked list where each node has two pointers: one to the next node and one to a random node (which can point anywhere in the list or be null).

---

2. **Problem Description:**

Given a linked list where each node contains two pointers:  
- `next` pointer to the next node in the sequence, and  
- `random` (arb) pointer which can point to any node in the list or null.

The task is to create a **deep copy** of this list. A deep copy means creating a new list with new nodes where both the `next` and `random` pointers of the new nodes replicate the structure of the original list. The original list must remain unmodified.

This problem is common in interview preparation because it tests understanding of linked list traversal, pointer manipulation, and the ability to handle complex node relationships efficiently without extra space usage beyond the output list.

---

3. **Examples:**

- **Example 1:**

  Input:  
  List: 1 -> 2 -> 3  
  Random pointers:  
  - Node 1's random points to Node 3  
  - Node 2's random points to Node 1  
  - Node 3's random points to Node 2  

  Output:  
  A new list 1' -> 2' -> 3' with the same next values (1,2,3)  
  Random pointers in new list:  
  - 1' points to 3'  
  - 2' points to 1'  
  - 3' points to 2'

- **Example 2 (Edge Case):**

  Input: Empty list (head is null).

  Output: null (deep copy is also an empty list).

---

4. **Solution Logic (Stepwise):**

1. **Clone list nodes without random pointers:**  
   Create a separate cloned list with only `next` pointers set by iterating over the original list.

2. **Interleave cloned nodes with original nodes:**  
   Insert each cloned node immediately after its corresponding original node inside the original list (e.g., original1 -> clone1 -> original2 -> clone2 ...).

3. **Assign random pointers to cloned nodes:**  
   For each original node, if its random pointer exists, set the cloned node's random pointer to `original->random->next` (which is the cloned node corresponding to the original node's random).

4. **Separate the original and cloned lists:**  
   Restore the original list `next` pointers and extract the cloned list by adjusting the `next` pointers accordingly.

5. **Return the head of the cloned list.**

---

- **Techniques used:**  
  Pointer manipulation, linked list traversal.

- **Time complexity:** O(N), where N is the number of nodes in the list (each step traverses the list a constant number of times).

- **Space complexity:** O(1) additional space (not counting output list), as the algorithm avoids using extra data structures for mapping node pairs.

---

5. **Java Implementation:**

public class Solution {

    // Definition for singly-linked list with a random pointer.
    public static class Node {
        int data;
        Node next;
        Node arb; // Random pointer

        Node(int data) {
            this.data = data;
            this.next = null;
            this.arb = null;
        }
    }

    // Helper method to insert a node at tail of list
    private void insertAtTail(Node[] headTail, int data) {
        Node newNode = new Node(data);
        if (headTail == null) {
            headTail = newNode;
            headTail[1] = newNode;
        } else {
            headTail[1].next = newNode;
            headTail[1] = newNode;
        }
    }

    public Node copyList(Node head) {
        if (head == null) return null;

        // Step 1: Create clone list - separate list with just data and next pointers
        Node cloneHead = null;
        Node cloneTail = null;

        Node temp = head;
        while (temp != null) {
            if (cloneHead == null) {
                cloneHead = new Node(temp.data);
                cloneTail = cloneHead;
            } else {
                cloneTail.next = new Node(temp.data);
                cloneTail = cloneTail.next;
            }
            temp = temp.next;
        }

        // Step 2: Insert clone nodes in between original nodes
        Node originalNode = head;
        Node cloneNode = cloneHead;

        while (originalNode != null && cloneNode != null) {
            Node originalNext = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = originalNext;

            Node cloneNext = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = cloneNext;
        }

        // Step 3: Assign random pointers for clone nodes
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

        // Step 4: Restore original list and separate cloned list
        originalNode = head;
        cloneNode = cloneHead;
        while (originalNode != null && cloneNode != null) {
            originalNode.next = (originalNode.next != null) ? originalNode.next.next : null;
            cloneNode.next = (cloneNode.next != null) ? cloneNode.next.next : null;
            originalNode = originalNode.next;
            cloneNode = cloneNode.next;
        }

        // Step 5: Return cloned list head
        return cloneHead;
    }

    // Optional: method to print list for validation
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.arb != null) {
                System.out.print("(" + curr.arb.data + ") ");
            } else {
                System.out.print("(null) ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method to run and test
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example: 1 -> 2 -> 3 with random pointers
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3;

        n1.arb = n3; // 1's random -> 3
        n2.arb = n1; // 2's random -> 1
        n3.arb = n2; // 3's random -> 2

        System.out.println("Original list:");
        sol.printList(n1);

        Node clone = sol.copyList(n1);

        System.out.println("Cloned list:");
        sol.printList(clone);

        System.out.println("Original list after cloning (should be unchanged):");
        sol.printList(n1);
    }
}
```java
class Solution {
    private class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
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

    private void insertAtTail(Node headRef, Node tailRef, int val) {

        Node temp = new Node(val);
        //empty list
        if (headRef == null) {
            headRef = temp;
            tailRef = temp;
            return;
        } else {
            tailRef.next = temp;
            tailRef = temp;
        }
    }

    private Node add(Node first, Node second) {
        int carry = 0;

        Node ansHead = null;
        Node ansTail = null;

        while (first != null || second != null || carry != 0) {

            int val1 = 0;
            if (first != null)
                val1 = first.data;

            int val2 = 0;
            if (second != null)
                val2 = second.data;


            int sum = carry + val1 + val2;

            int digit = sum % 10;

            //create node and add in answer Linked List
            insertAtTail(ansHead, ansTail, digit);

            carry = sum / 10;
            if (first != null)
                first = first.next;

            if (second != null)
                second = second.next;
        }
        return ansHead;
    }

    //Function to add two numbers represented by linked list.
    public Node addTwoLists(Node first, Node second) {
        //step 1 -  reverse input LL
        first = reverse(first);
        second = reverse(second);

        //step2 - add 2 LL
        Node ans = add(first, second);

        //step 3 
        ans = reverse(ans);

        return ans;
    }
}
```

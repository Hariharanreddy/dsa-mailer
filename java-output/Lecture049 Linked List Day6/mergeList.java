```java
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        next = null;
        this->data = data;
    }
}

class Solution {
    // Function to merge two sorted linked lists
    void solve(Node<Integer> first, Node<Integer> second) {
        Node<Integer> curr1 = first;
        Node<Integer> next1 = curr1.next;

        Node<Integer> curr2 = second;
        Node<Integer> next2 = curr2.next;

        while (next1 != null && curr2 != null) {
            if (curr2.data >= curr1.data && curr2.data <= next1.data) {
                curr1.next = curr2;
                curr2.next = next1;
                curr1 = curr2;
                curr2 = next2;
            }
            next1 = curr1.next;
        }

    }

    Node<Integer> sortTwoLists(Node<Integer> first, Node<Integer> second) {
        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data <= second.data) {
            solve(first, second);
            return first;
        } else {
            solve(second, first);
            return second;
        }

    }
}
```

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    //Function to check whether a binary tree is balanced or not.
    static class Pair {
        boolean first;
        int second;

        Pair(boolean first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    Pair isBalancedFast(Node root) {
        // base case
        if (root == null) {
            Pair p = new Pair(true, 0);
            return p;
        }

        Pair left = isBalancedFast(root.left);
        Pair right = isBalancedFast(root.right);

        boolean leftAns = left.first;
        boolean rightAns = right.first;

        boolean diff = Math.abs(left.second - right.second) <= 1;

        Pair ans = new Pair(false, 0); // Initialize ans.first to false
        ans.second = Math.max(left.second, right.second) + 1;

        if (leftAns && rightAns && diff) {
            ans.first = true;
        }
        return ans;
    }

    boolean isBalanced(Node root) {
        return isBalancedFast(root).first;
    }
}

class GFG {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node curr = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                curr.left = new Node(Integer.parseInt(currVal));
                queue.add(curr.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                curr.right = new Node(Integer.parseInt(currVal));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            System.out.println(ob.isBalanced(root));
        }
    }
}
```

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}


class Solution {
    //Function to check if two trees are identical.
    boolean isIdentical(Node r1, Node r2) {
        // base case
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null && r2 != null) {
            return false;
        }

        if (r1 != null && r2 == null) {
            return false;
        }

        boolean left = isIdentical(r1.left, r2.left);
        boolean right = isIdentical(r1.right, r2.right);

        boolean value = r1.data == r2.data;


        if (left && right && value) {
            return true;
        } else {
            return false;
        }

    }

}

// Function to Build Tree
Node buildTree(String str) {
    // Corner Case
    if (str.length() == 0 || str.charAt(0) == 'N') {
        return null;
    }

    // Creating vector of strings from input
    // string after spliting by space
    String[] ip = str.split(" ");

    // Create the root of the tree
    Node root = new Node(Integer.parseInt(ip[0]));

    // Push the root to the queue
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    // Starting from the second element
    int i = 1;
    while (!queue.isEmpty() && i < ip.length) {

        // Get and remove the front of the queue
        Node currNode = queue.peek();
        queue.remove();

        // Get the current node's value from the string
        String currVal = ip[i];

        // If the left child is not null
        if (!currVal.equals("N")) {

            // Create the left child for the current node
            currNode.left = new Node(Integer.parseInt(currVal));

            // Push it to the queue
            queue.add(currNode.left);
        }

        // For the right child
        i++;
        if (i >= ip.length) {
            break;
        }

        currVal = ip[i];

        // If the right child is not null
        if (!currVal.equals("N")) {

            // Create the right child for the current node
            currNode.right = new Node(Integer.parseInt(currVal));

            // Push it to the queue
            queue.add(currNode.right);
        }
        i++;
    }

    return root;
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            Node root1 = buildTree(s1);
            Node root2 = buildTree(s2);
            Solution obj = new Solution();
            boolean res = obj.isIdentical(root1, root2);

            if (res == true)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}

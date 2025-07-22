import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node() {
        data = 0;
        left = right = null;
    }

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    //Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1, int n2) {
        //base case
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftAns = lca(root.left, n1, n2);
        Node rightAns = lca(root.right, n1, n2);

        if (leftAns != null && rightAns != null) {
            return root;
        } else if (leftAns != null && rightAns == null) {
            return leftAns;
        } else if (leftAns == null && rightAns != null) {
            return rightAns;
        } else {
            return null;
        }
    }
}

class GFG {
    static Node newNode(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.left = null;
        temp.right = null;

        return temp;
    }

    // Function to Build Tree
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Creating vector of strings from input
        // string after spliting by space
        String[] ip = str.split(" ");

        // Create the root of the tree
        Node root = newNode(Integer.parseInt(ip[0]));

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
                currNode.left = newNode(Integer.parseInt(currVal));

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
                currNode.right = newNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    // Function for Inorder Traversal
    static void printInorder(Node root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int a = Integer.parseInt(inputLine[0]);
            int b = Integer.parseInt(inputLine[1]);

            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution ob = new Solution();
            System.out.println(ob.lca(root, a, b).data);
        }
    }
}

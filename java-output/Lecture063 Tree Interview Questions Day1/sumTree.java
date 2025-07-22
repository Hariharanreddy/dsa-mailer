import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Utility function to create a new Tree Node
    Node newNode(int val) {
        Node temp = new Node(val);
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Function to Build Tree
    Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

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
            if (i >= ip.length)
                break;
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


    // Should return true if tree is Sum Tree, else false
    class Pair {
        boolean first;
        int second;

        Pair(boolean first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    Pair isSumTreeFast(Node root) {

        //base case
        if (root == null) {
            return new Pair(true, 0);
        }

        if (root.left == null && root.right == null) {
            return new Pair(true, root.data);
        }

        Pair leftAns = isSumTreeFast(root.left);
        Pair rightAns = isSumTreeFast(root.right);

        boolean isLeftSumTree = leftAns.first;
        boolean isRightSumTree = rightAns.first;

        int leftSum = leftAns.second;
        int rightSum = rightAns.second;

        boolean condn = root.data == leftSum + rightSum;

        Pair ans = new Pair(false, 0);

        if (isLeftSumTree && isRightSumTree && condn) {
            ans.first = true;
            ans.second = root.data + leftSum + rightSum;
        }

        return ans;

    }
    boolean isSumTree(Node root) {
        return isSumTreeFast(root).first;
    }
}


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Solution ob = new Solution();
            Node root = ob.buildTree(s);
            System.out.println(ob.isSumTree(root));
        }
    }
}

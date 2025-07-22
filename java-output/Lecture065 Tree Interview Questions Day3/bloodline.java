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
    // Recursive helper function to find the sum of the longest root-to-leaf path
    void solve(Node root, int sum, int[] maxSum, int len, int[] maxLen) {
        // Base case: if the current node is null
        if (root == null) {
            // If the current path length is greater than the maximum length found so far
            if (len > maxLen[0]) {
                maxLen[0] = len;
                maxSum[0] = sum;
            }
            //If the current path length is equal to the maximum length found so far
            else if (len == maxLen[0]) {
                maxSum[0] = Math.max(sum, maxSum[0]);
            }
            return;
        }

        sum = sum + root.data;

        solve(root.left, sum, maxSum, len + 1, maxLen);
        solve(root.right, sum, maxSum, len + 1, maxLen);
    }

    int sumOfLongRootToLeafPath(Node root) {
        int len = 0;
        int[] maxLen = new int[1];
        maxLen[0] = 0;

        int sum = 0;
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;

        solve(root, sum, maxSum, len, maxLen);

        return maxSum[0];
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Creating vector of strings from input
        // string after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current Node
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            int res = obj.sumOfLongRootToLeafPath(root);

            System.out.println(res);
        }
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    // Recursive function to traverse the tree and find paths with sum k
    void solve(Node root, int k, int[] count, ArrayList<Integer> path) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // Add the current node's data to the path
        path.add(root.data);

        // Recursively traverse the left and right subtrees
        solve(root.left, k, count, path);
        solve(root.right, k, count, path);

        // Check if the current path has a sum equal to k
        int size = path.size();
        int sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                count[0]++;
            }
        }

        // Remove the current node's data from the path before returning
        path.remove(path.size() - 1);
    }

    // Function to find the number of paths with sum k
    int sumK(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        int[] count = new int[1]; // Use an array to pass count by reference
        solve(root, k, count, path);
        return count[0];
    }

    // Function to build the tree from the input string
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
            Node currNode = queue.poll();

            // Get the current Node's value from the string
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

                // Create the right child for the current Node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = new Solution().buildTree(s);

            int k = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            System.out.println(ob.sumK(root, k));
        }
    }
}

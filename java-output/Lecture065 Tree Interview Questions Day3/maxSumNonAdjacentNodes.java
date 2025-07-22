import java.util.*;
import java.lang.*;
import java.io.*;

// Tree Node
class Node {
    int data;
    Node left;
    Node right;
}

// Utility function to create a new Tree Node
Node newNode(int val) {
    Node temp = new Node();
    temp.data = val;
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
        Node currNode = queue.poll();
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


class Solution {
    //Function to return the maximum sum of non-adjacent nodes.
    Pair<Integer, Integer> solve(Node root) {
        //base case
        if (root == null) {
            Pair<Integer, Integer> p = new Pair<>(0, 0);
            return p;
        }
        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);
        Pair<Integer, Integer> res = new Pair<>(0,0);
        res.first = root.data + left.second + right.second;
        res.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        return res;
    }
    int getMaxSum(Node root) {
        Pair<Integer, Integer> ans = solve(root);
        return Math.max(ans.first, ans.second);
    }
    class Pair<K,V>{
        K first;
        V second;
        Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution ob = new Solution();
            System.out.println(ob.getMaxSum(root));
        }
    }
}

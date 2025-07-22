import java.util.*;
import java.lang.*;
import java.io.*;

/* A binary tree node has data, pointer to left child
   and a pointer to right child */
class Node {
    int data;
    Node left;
    Node right;
    Node(int val){
        data = val;
        left = null;
        right = null;
    }
}
class BuildTree{
    Node buildTree(String str){
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
            // Get the current node's value from the string
            String currVal = ip[i];
            // If the left child is not null
            if(!currVal.equals("N")) {
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
            // For the right child
            i++;
            if(i >= ip.length) break;
            currVal = ip[i];
            // If the right child is not null
            if(!currVal.equals("N")) {
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}

class Solution{
    private int height(Node node){
        //base case
        if(node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        int ans = Math.max(left, right) + 1;
        return ans;
    }
    private Pair diameterFast(Node root) {
        //base case
        if(root == null) {
            return new Pair(0,0);
        }

        Pair left = diameterFast(root.left);
        Pair right = diameterFast(root.right);

        int op1 = left.first;
        int op2 = right.first;
        int op3 = left.second + right.second + 1;

        Pair ans = new Pair(0,0);
        ans.first = Math.max(op1, Math.max(op2, op3));
        ans.second = Math.max(left.second , right.second) + 1;

        return ans;
    }
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int diameter(Node root){
        return diameterFast(root).first;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BuildTree bt = new BuildTree();
        while(t-- > 0){
            String s = br.readLine();
            Node root = bt.buildTree(s);
            Solution ob = new Solution();
            System.out.println(ob.diameter(root));
        }
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=right=null;
    }
}

class Solution {
    // Function to Build Tree
    Node buildTree(String str){
        // Corner Case
        if(str.length() == 0 || str.charAt(0) == 'N'){
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
        while(queue.size() > 0 && i < ip.length){
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")){
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")){
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    void traverseLeft(Node root, ArrayList<Integer> ans){
        //base case
        if( (root == null) || (root.left == null && root.right == null) )
            return ;

        ans.add(root.data);
        if(root.left != null)
            traverseLeft(root.left, ans);
        else
            traverseLeft(root.right, ans);

    }

    void traverseLeaf(Node root, ArrayList<Integer> ans){
        //base case
        if(root == null)
            return ;

        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }

        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);

    }

    void traverseRight(Node root, ArrayList<Integer> ans){
        //base case
        if( (root == null) || (root.left == null && root.right == null) )
            return ;

        if(root.right != null)
            traverseRight(root.right, ans);
        else
            traverseRight(root.left, ans);

        //wapas aagye
        ans.add(root.data);

    }

    ArrayList<Integer> boundary(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        ans.add(root.data);

        //left part print/store
        traverseLeft(root.left, ans);

        //traverse Leaf Nodes

        //left subtree
        traverseLeaf(root.left, ans);
        //right subtree
        traverseLeaf(root.right, ans);

        //traverse right part
        traverseRight(root.right, ans);

        return ans;


    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Solution obj = new Solution();
            Node root = obj.buildTree(s);
            ArrayList<Integer> res = obj.boundary(root);
            for(int i : res)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

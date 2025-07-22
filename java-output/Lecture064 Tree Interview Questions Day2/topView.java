import java.util.*;
import java.lang.*;
import java.io.*;

// Tree Node
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
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer, Integer> topNode = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> temp = q.poll();
            Node frontNode = temp.getKey();
            int hd = temp.getValue();

            //if one value is present for a HD, then do nothing
            if (!topNode.containsKey(hd)) {
                topNode.put(hd, frontNode.data);
            }

            if (frontNode.left != null) {
                q.add(new Pair<>(frontNode.left, hd - 1));
            }
            if (frontNode.right != null) {
                q.add(new Pair<>(frontNode.right, hd + 1));
            }
        }

        for (Integer i : topNode.values()) {
            ans.add(i);
        }
        return ans;
    }
}


//Function to Build Tree
class BuildTree {
    public Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) {
                break;
            }
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}


class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            BuildTree bt = new BuildTree();
            Node root = bt.buildTree(s);
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.topView(root);
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

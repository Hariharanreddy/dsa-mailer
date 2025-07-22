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

class GFG {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
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
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                curr.right = new Node(Integer.parseInt(currVal));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static Node solve(Node root, Integer k, int node) {
        if (root == null)
            return null;

        if (root.data == node) {
            return root;
        }

        Node leftAns = solve(root.left, k, node);
        Node rightAns = solve(root.right, k, node);

        if (leftAns != null && rightAns == null) {
            k--;
            if (k <= 0) {
                k = Integer.MAX_VALUE;
                return root;
            }
            return leftAns;
        }

        if (leftAns == null && rightAns != null) {
            k--;
            if (k <= 0) {
                k = Integer.MAX_VALUE;
                return root;
            }
            return rightAns;
        }
        return null;
    }

    static int kthAncestor(Node root, int k, int node) {
        Integer kObj = k; //Autoboxing to use Integer as a reference type
        Node ans = solve(root, kObj, node);
        if (ans == null || ans.data == node)
            return -1;
        else
            return ans.data;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int node = Integer.parseInt(inputLine[1]);
            String treeString = br.readLine().trim();
            Node root = buildTree(treeString);
            System.out.println(kthAncestor(root, k, node));
        }
    }
}

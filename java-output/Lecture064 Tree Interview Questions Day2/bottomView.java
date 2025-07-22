import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> topNode = new HashMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> temp = q.poll();
            Node frontNode = temp.getKey();
            int hd = temp.getValue();

            topNode.put(hd, frontNode.data);

            if (frontNode.left != null)
                q.offer(new Pair<>(frontNode.left, hd - 1));
            if (frontNode.right != null)
                q.offer(new Pair<>(frontNode.right, hd + 1));
        }

        for (int i : topNode.values()) {
            ans.add(i);
        }
        return ans;
    }
}

class GFG {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.bottomView(root);
            for (int i : res)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

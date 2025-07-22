```java
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
    // Function to Build Tree
    Node buildTree(String str) {
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
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    // Function to find the vertical order traversal of Binary Tree.
    ArrayList<Integer> verticalOrder(Node root) {
        Map<Integer, Map<Integer, ArrayList<Integer>>> nodes = new HashMap<>();
        Queue<Pair<Node, Pair<Integer, Integer>>> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!q.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> temp = q.poll();
            Node frontNode = temp.getKey();
            int hd = temp.getValue().getKey();
            int lvl = temp.getValue().getValue();

            nodes.computeIfAbsent(hd, k -> new HashMap<>()).computeIfAbsent(lvl, k -> new ArrayList<>()).add(frontNode.data);

            if (frontNode.left != null)
                q.add(new Pair<>(frontNode.left, new Pair<>(hd - 1, lvl + 1)));

            if (frontNode.right != null)
                q.add(new Pair<>(frontNode.right, new Pair<>(hd + 1, lvl + 1)));
        }

        for (Map.Entry<Integer, Map<Integer, ArrayList<Integer>>> entry1 : nodes.entrySet()) {
            for (Map.Entry<Integer, ArrayList<Integer>> entry2 : entry1.getValue().entrySet()) {
                for (int val : entry2.getValue()) {
                    ans.add(val);
                }
            }
        }
        return ans;
    }
}

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            Node root = obj.buildTree(s);
            ArrayList<Integer> res = obj.verticalOrder(root);
            for (int i : res) System.out.print(i + " ");
            System.out.println();
        }
    }
}
```

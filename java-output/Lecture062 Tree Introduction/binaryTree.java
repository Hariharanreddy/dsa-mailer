import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {

    // Build the tree recursively using preorder traversal
    Node buildTree(Node root) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int data = sc.nextInt();
        root = new Node(data);

        if (data == -1) {
            return null;
        }

        System.out.println("Enter data for inserting in left of " + data);
        root.left = buildTree(root.left);
        System.out.println("Enter data for inserting in right of " + data);
        root.right = buildTree(root.right);
        return root;
    }

    // Level order traversal
    void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
    }


    // Inorder traversal
    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder traversal
    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder traversal
    void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Build tree from level order input
    void buildFromLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for root");
        int data;
        data = sc.nextInt();
        root = new Node(data);
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.println("Enter left node for: " + temp.data);
            int leftData = sc.nextInt();
            if (leftData != -1) {
                temp.left = new Node(leftData);
                q.offer(temp.left);
            }
            System.out.println("Enter right node for: " + temp.data);
            int rightData = sc.nextInt();
            if (rightData != -1) {
                temp.right = new Node(rightData);
                q.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null;
        tree.buildFromLevelOrder(root);
        tree.levelOrderTraversal(root);

    }
}

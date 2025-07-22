import java.util.*;
class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to count leaf nodes using inorder traversal
    void inorder(BinaryTreeNode root, int[] count) {
        // Base case: If the node is null, return
        if (root == null) {
            return;
        }

        inorder(root.left, count);

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            count[0]++;
        }

        inorder(root.right, count);
    }

    // Function to count leaf nodes in a binary tree
    int noOfLeafNodes(BinaryTreeNode root) {
        int[] cnt = {0}; // Using an array to pass the count by reference
        inorder(root, cnt);
        return cnt[0];
    }
}

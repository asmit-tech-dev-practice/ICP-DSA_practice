import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int value) {
        this.val = value;
        left = right = null;
    }
}

public class LeftViewBinaryTree {

    public static void printLeftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    System.out.print(curr.val + " ");
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        /*
               1
             /   \
            2     3
           / \     \
          4   5     6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);    
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Left view of binary tree: ");
        printLeftView(root);
    }
}

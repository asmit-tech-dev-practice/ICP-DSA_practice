import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class VerticalOrderTraversal {

    static class NodeInfo {
        TreeNode node;
        int hd;

        NodeInfo(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }

    public static void verticalOrder(TreeNode root) {
        if (root == null) return;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();

        queue.offer(new NodeInfo(root, 0));

        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            TreeNode currNode = current.node;
            int hd = current.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(currNode.val);

            if (currNode.left != null) {
                queue.offer(new NodeInfo(currNode.left, hd - 1));
            }

            if (currNode.right != null) {
                queue.offer(new NodeInfo(currNode.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int val : entry.getValue()) {
                System.out.print(val + " ");
            }
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
                    \
                     8
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println("Vertical Order Traversal:");
        verticalOrder(root);
    }
}

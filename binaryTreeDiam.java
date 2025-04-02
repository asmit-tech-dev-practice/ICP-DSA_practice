import javax.swing.tree.TreeNode;

class TreeN {
    int val;
    TreeN left, right;

    TreeN (int val){
        this.val = val;
        left = right = null;
    }
}

public class binaryTreeDiam {

    public static class Tree {
        int height;
        int diameter;

        Tree (int height, int diameter){
            this.height = height;
            this.diameter = diameter;

        }
    }

    public static Tree diamHelper (TreeN root) {
        if (root == null) {
            return new Tree (0,0);

        }

        Tree left = diamHelper(root.left);
        Tree right = diamHelper(root.right);

        int height = 1 + Math.max(left.height, right.height);
        int Rdiameter = Math.max(left.diameter, right.diameter);

        int maxDiameter = Math.max(Rdiameter, left.height + right.height); 
        return new Tree(height, maxDiameter);
    }

    public static int diamOfBinaryTree (TreeN root){
        return diamHelper(root).diameter;
    }
    
    public static void main(String[] args) {

        TreeN root = new TreeN(1);
        root.left = new TreeN(2);
        root.right=new TreeN(3);
        root.left.left=new TreeN(5);
        root.left.right=new TreeN(4);
        root.left.left.left=new TreeN(6);

        System.out.println(diamOfBinaryTree(root));
    }

}

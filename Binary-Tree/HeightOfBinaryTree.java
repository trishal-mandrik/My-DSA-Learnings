
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class HeightOfBinaryTree {
    public int maxHeight(TreeNode root) {
        if(root == null) return 0;

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return 1 + Math.max(lh, rh);
    }
}

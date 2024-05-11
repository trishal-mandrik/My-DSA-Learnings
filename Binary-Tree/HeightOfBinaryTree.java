public class HeightOfBinaryTree {
    public int maxHeight(TreeNode root) {
        if (root == null) return 0;

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return 1 + Math.max(lh, rh);
    }
}

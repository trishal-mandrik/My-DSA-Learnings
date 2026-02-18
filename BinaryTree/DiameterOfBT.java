public class DiameterOfBT {
    public int findDiameter(TreeNode root) {
        int[] diameter = new int[1];
        heightAndDiameter(root, diameter);
        return diameter[0];
    }

    private int heightAndDiameter(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int lh = heightAndDiameter(root.left, diameter);
        int rh = heightAndDiameter(root.right, diameter);

        diameter[0] = Math.max((lh + rh), diameter[0]);
        return 1 + Math.max(lh, rh);
    }
}


// TC: O(N) where N is the number of nodes in the binary tree
// SC: O(N), in worst case
public class MaxPathSumOfBT {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathDown(root, max);
        return max[0];
    }

    private int maxPathDown(TreeNode node, int[] maxValue) {
        if(node == null) return 0;
        int left = maxPathDown(node.left, maxValue);
        int right = maxPathDown(node.right, maxValue);

        maxValue[0] = Math.max(maxValue[0], right + left + node.val);
        return Math.max(left, right) + 1;
    }
}

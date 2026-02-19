public class MaxPathSumOfBT {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathDown(root, max);
        return max[0];
    }

    private int maxPathDown(TreeNode node, int[] maxValue) {
        if (node == null) return 0;
        int left = Math.max(maxPathDown(node.left, maxValue), 0);
        int right = Math.max(maxPathDown(node.right, maxValue), 0);
        // If a subtree has a negative path sum, including it would decrease the overall path sum
        // By comparing with 0, you effectively ignore negative paths (treat them as non-existent)
        // This allows you to "cut off" branches that would harm the maximum path sum
        // Left subtree returns -5
        // Math.max(-5, 0) = 0 → ignore the negative left path
        // Only include the right path with value 3
        // Maximum path sum = 10 + 0 + 3 = 13 instead of 10 + (-5) + 3 = 8
        maxValue[0] = Math.max(maxValue[0], right + left + node.val);
        return Math.max(left, right) + node.val;
    }
}

// TC: O(N) where N is the number of nodes in the binary tree
// SC: O(H), auxiliary stack space, where H is height of Binary Tree
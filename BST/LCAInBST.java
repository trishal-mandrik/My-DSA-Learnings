package BST;

public class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;

        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

// TC: O(H) SC: O(1)
package BST;

public class CeilOfBT {
    public static int findCeil(TreeNode node, int x) {
        int ceil = -1;

        while (node != null) {
            if (node.val == x) {
                ceil = node.val;
                return ceil;
            }

            if (x > node.val) node = node.right;
            else {
                ceil = node.val;
                node = node.left;
            }
        }
        return ceil;
    }
}

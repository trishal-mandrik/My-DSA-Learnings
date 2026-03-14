import java.util.ArrayList;
import java.util.List;

class LeftViewOfBT {
    void preorder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (level == ans.size()) ans.add(root.val);

        preorder(root.left, level + 1, ans);
        preorder(root.right, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, 0, ans);
        return ans;
    }
}

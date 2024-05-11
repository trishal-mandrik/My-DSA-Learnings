import java.util.ArrayList;
import java.util.List;

class Solution {
    void reversePreorder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (level == ans.size()) ans.add(root.val);

        reversePreorder(root.right, level + 1, ans);
        reversePreorder(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        reversePreorder(root, 0, ans);
        return ans;
    }
}

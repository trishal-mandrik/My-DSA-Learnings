import java.util.ArrayList;
import java.util.List;

public class RightViewOfBT {
    public void reversePreOrder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (level == ans.size()) ans.add(root.val);

        reversePreOrder(root.right, level + 1, ans);
        reversePreOrder(root.left, level + 1, ans);
    }

    public List<Integer> rightView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        reversePreOrder(root, 0, ans);
        return ans;
    }
}

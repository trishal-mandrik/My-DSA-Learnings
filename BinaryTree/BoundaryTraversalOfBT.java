import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversalOfBT {
    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

    private void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (isLeaf(curr) == false) res.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    private void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        Stack<Integer> stack = new Stack<Integer>();
        while (curr != null) {
            if (isLeaf(curr) == false) stack.push(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for (int i = 0; i < stack.size(); i++) {
            res.add(stack.pop());
        }
    }

    List<Integer> printBoundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (isLeaf(root) == false) ans.add(root.val);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
}

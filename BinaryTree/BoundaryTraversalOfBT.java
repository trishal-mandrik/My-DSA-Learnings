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
            if (!isLeaf(curr)) res.add(curr.val);  //add if not leaf
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
            if (!isLeaf(curr)) stack.push(curr.val); //add if not leaf
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for (int i = 0; i < stack.size(); i++) {
            res.add(stack.pop());
        }
    }

    List<Integer> printBoundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.val); //add if not leaf
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
}

//Complexity Analysis
//Time Complexity: O(N) where N is the number of nodes in the Binary Tree.
//
//Adding the left boundary of the Binary Tree results in the traversal of the left side of the tree which is proportional to the the height of the three hence O(H) ie. O(log2N). In the worst case that the tree is skewed the complexity would be O(N).
//For the bottom traversal of the Binary Tree, traversing the leaves is proportional to O(N) as preorder traversal visits every node once.
//Adding the right boundary of the Binary Tree results in the traversal of the right side of the tree which is proportional to the the height of the three hence O(H) ie. O(log2N). In the worst case that the tree is skewed the complexity would be O(N).
//Since all these operations are performed sequentially, the overall time complexity is dominated by the most expensive operation, which is O(N).
//Space Complexity: O(N) where N is the number of nodes in the Binary Tree to store the boundary nodes of the tree. O(H) or O(log2N) Recursive stack space while traversing the tree. In the worst case scenario the tree is skewed and the auxiliary recursion stack space would be stacked up to the maximum depth of the tree, resulting in an O(N) auxiliary space complexity.

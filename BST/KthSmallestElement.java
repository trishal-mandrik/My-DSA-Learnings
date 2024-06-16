package BST;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    List<Integer> elm = new ArrayList<>();

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        elm.add(root.val);
        inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return elm.get(k - 1);
    }
}

// TC: O(n) SC: O(n)
// use morris inorder traversal for sc o(1)
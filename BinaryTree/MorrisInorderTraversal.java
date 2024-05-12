import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        TreeNode curr = root;
        if (root == null) return inorder;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}

// 1. Initialize arraylist for storing inorder Traversal
// 2. If root is null return empty list
// 3. Initialize curr to root
// 4. Initialize while loop and check if curr != null
// 5. Inside while loop:
// case 1: if curr.left == null :
// a. add currrent val to inorder
// b. move curr to curr.right
// case 2:
package BST;

public class ValidateBST {
    public boolean isBST(Node root) {
        // code here
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(Node root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.data >= maxVal || root.data <= minVal) return false;
        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
    }
}

// TC: O(N)
// SC: O(1)
package BST;

public class SearchINBst {
    public Node searchBST(Node root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}

// TC: O(logH) SC: O(1)
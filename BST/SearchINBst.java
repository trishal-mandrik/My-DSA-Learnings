package BST;

public class SearchINBst {
    public Node searchBST(Node root, int val) {
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }
}

// TC: O(logH) SC: O(1)
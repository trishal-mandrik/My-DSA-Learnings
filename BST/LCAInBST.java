package BST;

public class LCAInBST {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (root.data < p.data && root.data < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.data > p.data && root.data > q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

// TC: O(H) SC: O(1)
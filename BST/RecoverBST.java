package BST;

public class RecoverBST {
    private Node first;
    private Node prev;
    private Node middle;
    private Node last;

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {
            // If this is first violation, mark these two nodes as 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // If this is second violation, mark these node as 'last'
                last = root;
            }
        }
        // Mark this node as previous
        prev = root;
        inorder(root.right);
    }

    public void recoverBST(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}

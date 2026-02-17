package BST;

public class InsertIntoBST {
    public Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        Node cur = root;
        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) cur = cur.right;
                else {
                    cur.right = new Node(val);
                    break;
                }
            } else {
                if (cur.left != null) cur = cur.left;
                else {
                    cur.left = new Node(val);
                    break;
                }
            }
        }
        return root;
    }
}

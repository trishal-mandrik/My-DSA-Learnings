package BST;

public class DeleteInBST {
    public Node delNode(Node root, int x) {
        // code here
        if (root == null) return null;

        if (root.data == x) return helper(root);
        Node rootCopy = root;

        while (root != null) {
            if (root.data > x) {
                if (root.left != null && root.left.data == x) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == x) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return rootCopy;
    }

    Node helper(Node root) {
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    Node findLastRight(Node root) {
        if (root.right == null) return root;
        return findLastRight(root.right);
    }
}

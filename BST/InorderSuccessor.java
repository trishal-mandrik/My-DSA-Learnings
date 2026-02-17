package BST;

public class InorderSuccessor {
    Node inOrderSuccessor(Node root, Node p) {
        Node successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}

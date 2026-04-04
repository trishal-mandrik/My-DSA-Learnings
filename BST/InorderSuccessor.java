package BST;

public class InorderSuccessor {
    Node inOrderSuccessor(Node root, Node p) {
        Node successor = null;

        while (root != null) {
            if (p.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}

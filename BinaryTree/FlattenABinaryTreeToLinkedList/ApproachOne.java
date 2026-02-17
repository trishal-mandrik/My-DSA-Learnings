package FlattenABinaryTreeToLinkedList;

import BST.Node;

public class ApproachOne {
    Node prev = null;

    public void flatten(Node node) {
        if (node == null) return;

        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}

//TC: O(N), SC: O(N)

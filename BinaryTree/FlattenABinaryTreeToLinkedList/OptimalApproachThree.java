package FlattenABinaryTreeToLinkedList;

import BST.Node;

public class OptimalApproachThree {
    public void flatten(Node root) {
        if (root == null) return;

        Node curr = root;
        Node prev = null;

        while (curr != null) {
            if(curr.left != null) {
                prev = curr.left;

                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr.left = null;
            curr = curr.right;
        }
    }
}

// TC: O(N), SC: O(1)
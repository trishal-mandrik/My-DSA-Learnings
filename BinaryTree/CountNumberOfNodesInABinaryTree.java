import NodeDefinition.Node;

public class CountNumberOfNodesInABinaryTree {
    public static int countNodes(Node root) {
        // Code here
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) return ((2 << leftHeight) - 1);

        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static int getLeftHeight(Node root) {
        int count = 0;

        while (root.left != null) {
            count++;
            root = root.left;
        }

        return count;
    }

    static int getRightHeight(Node root) {
        int count = 0;

        while (root.right != null) {
            count++;
            root = root.right;
        }

        return count;
    }
}

// TC: O(logN * logN) -> O(logN) for calculating the height and O(logN) for the recursive calls.
// SC: O(logN)
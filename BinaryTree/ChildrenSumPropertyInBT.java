public class ChildrenSumPropertyInBT {
    public static void childSumProperty(Node root) {
        if (root == null) return;
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child > root.data) {
            root.data = child;
        } else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        childSumProperty(root.left);
        childSumProperty(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total;
    }
}

//TC: O(N) SC: O(1)

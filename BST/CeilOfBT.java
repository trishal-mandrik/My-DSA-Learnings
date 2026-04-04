package BST;

public class CeilOfBT {
    public static int findCeil(Node node, int x) {
        int ceil = -1;

        while (node != null) {
            if (node.data == x) {
                ceil = node.data;
                return ceil;
            }

            if (x > node.data) node = node.right;
            else {
                ceil = node.data;
                node = node.left;
            }
        }
        return ceil;
    }
}

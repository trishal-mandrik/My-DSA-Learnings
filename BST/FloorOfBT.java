package BST;

public class FloorOfBT {
    public static int floorInBST(Node node, int x) {
        int floor = -1;

        while (node != null) {
            if (node.data == x) {
                floor = node.data;
                return floor;
            }

            if (x > node.data) {
                floor = node.data;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return floor;
    }
}

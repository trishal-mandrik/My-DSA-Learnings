package BST;

public class FloorOfBT {
    public static int floorInBST(TreeNode node, int x) {
        int floor = -1;

        while(node != null) {
            if(node.val == x) {
                floor = node.val;
                return floor;
            }

            if(x > node.val) {
                floor = node.val;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return floor;
    }
}

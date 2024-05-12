import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversalOfBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);
        boolean isLeftToRight = true;

        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            ArrayList<Integer> row = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQueue.poll();

                int index = (isLeftToRight) ? i : (size - 1 - i);
                row.add(index, node.val);

                if (node.left != null) {
                    nodesQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodesQueue.offer(node.right);
                }
            }
            result.add(row);
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }
}

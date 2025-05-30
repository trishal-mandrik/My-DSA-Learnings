import java.util.LinkedList;
import java.util.Queue;

class TempPair {
    TreeNode node;
    int num;

    TempPair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}

public class WidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;

        Queue<TempPair> q = new LinkedList<>();
        q.offer(new TempPair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int curr_id = q.peek().num - mmin;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0)
                    first = curr_id;
                if (i == size - 1)
                    last = curr_id;

                if (node.left != null)
                    q.offer(new TempPair(node.left, curr_id * 2 + 1));
                if (node.right != null)
                    q.offer(new TempPair(node.right, curr_id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

}

import java.util.*;

public class BottomViewOfBT {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        if (root == null) return ans;
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node n = p.node;
            int line = p.line;

            map.put(line, n.data);

            if (n.left != null) q.add(new Pair(n.left, line - 1));
            if (n.right != null) q.add(new Pair(n.right, line + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}

import java.util.*;

class Pair {
    Node node;
    int line;

    Pair(Node node, int line) {
        this.node = node;
        this.line = line;
    }
}

public class TopViewOfBT {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> mpp = new TreeMap<>();

        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int line = p.line;

            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            if(node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }

            if(node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}

// TC: O(n) SC: O(n)
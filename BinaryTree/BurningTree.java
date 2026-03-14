import NodeDefinition.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurningTree {
    void markParent(Node root, HashMap<Node, Node> parent) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.left != null) {
                parent.put(current.left, current);
                q.offer(current.left);
            }
            if (current.right != null) {
                parent.put(current.right, current);
                q.offer(current.right);
            }
        }
    }

    Node findTargetNodeAddress(Node root, int target) {
        if (root != null && target == root.data) return root;
        if (root == null) return null;
        Node left = findTargetNodeAddress(root.left, target);
        if (left != null) return left;
        Node right = findTargetNodeAddress(root.right, target);
        if (right != null) return right;
        return null;
    }

    public int minTime(Node root, int target) {
        // code here
        HashMap<Node, Node> parent = new HashMap<>();
        Node targetNodeAddress = findTargetNodeAddress(root, target);
        markParent(root, parent);
        HashSet<Node> visited = new HashSet<>(); // To keep track of visited nodes
        Queue<Node> q = new LinkedList<>(); // Queue for BFS
        visited.add(targetNodeAddress);
        q.offer(targetNodeAddress);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    q.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    q.offer(current.right);
                    visited.add(current.right);
                }
                if (parent.containsKey(current) && !visited.contains(parent.get(current))) {
                    q.offer(parent.get(current));
                    visited.add(parent.get(current));
                }
            }
            level++;
        }
        return level - 1;
    }
}

// TC: O(3N)
// SC: O(3N)
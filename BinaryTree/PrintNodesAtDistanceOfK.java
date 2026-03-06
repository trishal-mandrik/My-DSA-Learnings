import java.util.*;

public class PrintNodesAtDistanceOfK {
    private void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current.left != null) {
                parent.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>(); // To store parent of each node
        markParents(root, parent); // Mark parents of all nodes
        HashSet<TreeNode> visited = new HashSet<>(); // To keep track of visited nodes
        Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
        queue.offer(target); // Start BFS from the target node
        visited.add(target); // Mark the target node as visited
        int curr_level = 0; // To keep track of the current level in BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_level == k) break;
            for (int i = 0; i < size; i++) {
                TreeNode current_node = queue.poll();
                // Check the left child
                if (current_node.left != null && !visited.contains(current_node.left)) {
                    visited.add(current_node.left);
                    queue.offer(current_node.left);
                }
                if (current_node.right != null && !visited.contains(current_node.right)) {
                    visited.add(current_node.right);
                    queue.offer(current_node.right);
                }
                if (parent.containsKey(current_node) && !visited.contains(parent.get(current_node))){
                    visited.add(parent.get(current_node));
                    queue.offer(parent.get(current_node));
                }
            }
            curr_level++;
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current_node = queue.poll();
            result.add(current_node.val);
        }
        return result;
    }
}

// TC: O(N) where N is the number of nodes in the tree. We are visiting each node once to mark parents and then again in BFS.
// SC: O(N) where N is the number of nodes in the tree. We are using a HashMap to store parent of each node and a HashSet to keep track of visited nodes. In worst case, both can store all nodes in the tree. The queue used for BFS can also store up to N nodes in the worst case when all nodes are at distance K from the target
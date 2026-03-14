import NodeDefinition.Node;

import java.util.ArrayList;

public class RootToLeavesPath {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<Integer> singlePath = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rootToLeafPath = new ArrayList<>();
        getAllPaths(root, singlePath, rootToLeafPath);
        return rootToLeafPath;
    }

    static void getAllPaths(Node root, ArrayList<Integer> singlePath, ArrayList<ArrayList<Integer>> rootToLeafPath) {
        if (root == null) {
            rootToLeafPath.add(new ArrayList<>(singlePath));
            return;
        }

        if (root.left == null && root.right == null) {
            singlePath.add(root.data);
            rootToLeafPath.add(new ArrayList<>(singlePath));
            singlePath.removeLast();
            return;
        }
        singlePath.add(root.data);
        if (root.left != null) getAllPaths(root.left, singlePath, rootToLeafPath);
        if (root.right != null) getAllPaths(root.right, singlePath, rootToLeafPath);
        singlePath.removeLast();
    }
}

// TC: O(N) where N is the number of nodes in the tree. We are visiting each node once.
// SC: O(H) where H is the height of the tree. This is the space used by the recursion stack. In worst case, H can be equal to N when the tree is skewed. In best case, H can be equal to logN when the tree is balanced.
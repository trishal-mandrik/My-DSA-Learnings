import java.util.ArrayList;

public class RootToNodePath {
    private boolean getPath(TreeNode root, ArrayList<Integer> arr, int x) {
        if (root == null) return false;

        arr.add(x);

        if (root.val == x) {
            return true;
        }

        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }
        arr.removeLast();
        return false;
    }

    public ArrayList<Integer> solve(TreeNode root, int x) {
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) return path;
        getPath(root, path, x);
        return path;
    }
}

public class HeightOfBinaryTree {
    public int maxHeight(TreeNode root) {
        if (root == null) return 0;

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return 1 + Math.max(lh, rh);
    }
}

// TC: O(N) where N is the number of nodes in the binary tree
// SC: O(N), in worst case, a maximum of N/2 nodes can be present in queue.

// For zero based indexing, we can return heightOfBT(root) - 1 instead of heightOfBT(root) in the above code. So the code will be as follows:

//public int height(Node root) {
//    // code here
//    if (root == null) return 0;
//    return heightOfBT(root) - 1;
//}
//
//int heightOfBT(Node root) {
//    if (root == null) return 0;
//
//    int lh = heightOfBT(root.left);
//    int rh = heightOfBT(root.right);
//
//    return 1 + Math.max(lh, rh);
//}
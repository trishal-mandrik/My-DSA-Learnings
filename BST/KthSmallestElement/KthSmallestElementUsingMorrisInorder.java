package BST.KthSmallestElement;

import BST.Node;

public class KthSmallestElementUsingMorrisInorder {
    public int kthSmallest(Node root, int k) {
        // code here
        Node curr = root;
        if (root == null) return -1;
        int count = 0;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if(count == k) return curr.data;
                curr = curr.right;
            } else {
                Node prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    count++;
                    if(count == k) return curr.data;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}

// TC: O(n) SC: O(1)

// NOTE: For largest Kth element watch strive video on youtube.
package BST;

public class BSTFromAPreorder {
    public Node Bst(int[] pre, int size) {
        // code here
        return bstFromPreorder(pre, Integer.MAX_VALUE, new int[1]);
    }

    public Node bstFromPreorder(int[] pre, int bound, int[] i) {
        if (i[0] == pre.length || pre[i[0]] > bound) return null;
        Node root = new Node(pre[i[0]++]);
        root.left = bstFromPreorder(pre, root.data, i);
        root.right = bstFromPreorder(pre, bound, i);
        return root;
    }
}

// TC: O(3N)
// SC: O(1)
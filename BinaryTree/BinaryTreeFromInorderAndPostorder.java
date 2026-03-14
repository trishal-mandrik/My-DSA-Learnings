import NodeDefinition.Node;

import java.util.HashMap;

public class BinaryTreeFromInorderAndPostorder {
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, hm);
    }

    Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
                   int pStart, int pEnd, HashMap<Integer, Integer> hm) {


        if (inStart > inEnd || pStart > pEnd) {
            return null;
        }

        Node root = new Node(postorder[pEnd]);

        int inorderRootIndex = hm.get(postorder[pEnd]);
        int numsLeft = inorderRootIndex - inStart;

        root.left = buildTree(inorder, inStart, inorderRootIndex - 1,
                postorder, pStart, pStart + numsLeft - 1, hm);

        root.right = buildTree(inorder, inorderRootIndex + 1, inEnd,
                postorder, pStart + numsLeft, pEnd - 1, hm);

        return root;
    }
}

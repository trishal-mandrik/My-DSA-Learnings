package FlattenABinaryTreeToLinkedList;

import BST.Node;

import java.util.Stack;

public class ApproachTwo {
    public void flatten(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);

            if(!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
}

// TC: O(N), SC: O(N)
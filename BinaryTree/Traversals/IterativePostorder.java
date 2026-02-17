package Traversals;

import NodeDefinition.Node;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePostorder {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if(root == null) return inorder;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty()) {
            Node node = st1.pop();
            st2.push(node);
            if (node.left != null) st1.push(node.left);
            if (node.right != null) st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            inorder.add(st2.pop().data);
        }
        return inorder;
    }
}

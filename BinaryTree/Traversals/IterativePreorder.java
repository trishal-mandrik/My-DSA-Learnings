package Traversals;

import BST.Node;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePreorder {
    ArrayList<Integer> preOrder(Node root) {
        // code here
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        if(root == null) return preorder;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node currentNode = st.pop();
            preorder.add(currentNode.val);
            if (currentNode.right != null) st.push(currentNode.right);
            if (currentNode.left != null) st.push(currentNode.left);
        }
        return preorder;
    }
}

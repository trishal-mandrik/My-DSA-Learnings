package Traversals;
import NodeDefinition.Node;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeInorder {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if(root == null) return inorder;

        Stack<Node> st = new Stack<>();
        Node node = root;

        while (true){
            if (node != null){
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }
}

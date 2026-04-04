package BST;

public class Node {
    public Node left;
    public Node right;
    public int data;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
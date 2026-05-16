package StackAndQueue.MinStack;

import java.util.Stack;

class SpecialStack {
    Stack<Pair> st;
    public SpecialStack() {
        // Define Stack
        st = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        if(st.isEmpty()) {
            st.push(new Pair(x, x));
        } else {
            st.push(new Pair(x, Math.min(x, st.peek().second)));
        }
    }

    public void pop() {
        // Remove the top element from the Stack
        if (!st.isEmpty()) {
            st.pop();
        }
    }

    public int peek() {
        // Returns top element of the Stack
        if (!st.isEmpty()) {
            return st.peek().first;
        } else return -1;
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return st.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if (!st.isEmpty()) {
            return st.peek().second;
        } else return -1;
    }
}

class Pair {
    int first, second;

    Pair(int _first, int _second) {
        first = _first;
        second = _second;
    }
}

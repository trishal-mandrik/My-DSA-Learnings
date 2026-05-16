package StackAndQueue.MinStack;

import java.util.Stack;

class SpecialStackOptimal {
    Stack<Integer> st;
    int min;

    public SpecialStackOptimal() {
        // Define Stack
        st = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        if(st.isEmpty()) {
            min = x;
            st.push(x);
        } else {
            if (x > min) st.push(x);
            else {
                st.push(2 * x - min);
                min = x;
            }
        }
    }

    public void pop() {
        // Remove the top element from the Stack
        if (!st.isEmpty()) {
            int top = st.pop();

            if (top < min)
                min = 2 * min - top;
        }
    }

    public int peek() {
        // Returns top element of the Stack
        if (!st.isEmpty()) {
            int top = st.peek();

            return Math.max(min, top);
        }
        return -1;
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return st.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if (!st.isEmpty()) {
            int top = st.peek();
            return Math.max(top, min);
        } else return -1;
    }
}

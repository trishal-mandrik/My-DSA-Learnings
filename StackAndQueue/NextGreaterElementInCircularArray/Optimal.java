package StackAndQueue.NextGreaterElementInCircularArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Optimal {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> nge = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i % n]) {
                st.pop();
            }

            if (i < n && !st.isEmpty()) {
                nge.set(i, st.peek());
            }

            st.push(arr[i % n]);
        }
        return nge;
    }
}

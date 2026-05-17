package StackAndQueue.PreviousSmallerElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Optimal {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> nse = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (!st.empty()) {
                nse.set(i, st.peek());
            }

            st.push(arr[i]);
        }
        return nse;
    }
}

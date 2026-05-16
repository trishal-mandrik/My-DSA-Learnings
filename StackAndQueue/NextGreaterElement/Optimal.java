package StackAndQueue.NextGreaterElement;

import java.util.*;

public class Optimal {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> nge = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                nge.set(i, st.peek());
            }

            st.push(arr[i]);
        }
        return nge;
    }
}

// TC: O(2N)
// SC: O(2N) stack + arraylist
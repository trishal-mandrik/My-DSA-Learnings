package StackAndQueue.NextGreaterElementInCircularArray;

import java.util.ArrayList;
import java.util.Collections;

public class Brute {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> nge = new ArrayList<>(Collections.nCopies(n, -1));


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + n - 1; j++) {
                int idx = j % n;

                if (arr[idx] > arr[i]) {
                    nge.set(i, arr[idx]);
                    break;
                }
            }
        }
        return nge;
    }
}

// TC: O(N ^ 2)
// SC: O(N)
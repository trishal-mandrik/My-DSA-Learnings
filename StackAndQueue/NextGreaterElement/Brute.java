package StackAndQueue.NextGreaterElement;

import java.util.ArrayList;
import java.util.Collections;

public class Brute {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> nge = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]){
                    nge.set(i, arr[j]);
                    break;
                }
            }
        }
        return nge;
    }
}

//TC: O(N ^ 2)
//SC: O(N)
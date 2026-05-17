package StackAndQueue.PreviousSmallerElement;

import java.util.ArrayList;
import java.util.Collections;

public class Brute {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> nse = new ArrayList<>(Collections.nCopies(n, -1));


        for(int i = 0; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]){
                    nse.set(i, arr[j]);
                    break;
                }
            }
        }
        return nse;
    }
}

//TC: O(n ^ 2)
//SC: O(n)
package Recursion;

import java.util.ArrayList;

public class RecursionOnSubsequences {
    void printF(int ind, ArrayList<Integer> ds, int[] arr, int n) {
        if (ind == n) {
            for (int it : ds) {
                System.out.print(it + " ");
            }
            if (ds.isEmpty()) System.out.print("{}");
            System.out.println();
            return;
        }

        // pick
        ds.add(arr[ind]);
        printF(ind + 1, ds, arr, n);
        ds.removeLast();

        // not pick
        printF(ind + 1, ds, arr, n);
    }

    void solve() {
        int[] arr = {3, 1, 2};
        int n = 3;
        ArrayList<Integer> ds = new ArrayList<>();
        printF(0, ds, arr, n);
    }
}

// TC: o(2 ^ N * N)
// SC: O(N)

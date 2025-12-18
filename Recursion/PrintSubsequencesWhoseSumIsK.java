package Recursion;

import java.util.ArrayList;

public class PrintSubsequencesWhoseSumIsK {
    boolean printS(int ind, ArrayList<Integer> ds, int s, int target, int[] arr, int n) {
        if (ind == n) {
            if (s == target) {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
                return true;
            } else return false;
        }

        ds.add(arr[ind]);
        s += arr[ind];
        if (printS(ind + 1, ds, s, target, arr, n)) return true;
        ds.removeLast();
        s -= arr[ind];

        // not pick
        if (printS(ind + 1, ds, s, target, arr, n)) return true;
        else return false;
    }

    void solve() {
        int[] arr = {3, 1, 2};
        int n = 3;
        int target = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        printS(0, ds, 0, target, arr, n);
    }
}

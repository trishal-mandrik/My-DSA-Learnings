package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum1 {
    void helper(int ind, int sum, int n, ArrayList<Integer> arr, ArrayList<Integer> sumSubset) {
        if (ind == n) {
            sumSubset.add(sum);
            return;
        }

        // pick the element
        helper(ind + 1, sum + arr.get(ind), n, arr, sumSubset);

        // dont pick the element
        helper(ind + 1, sum, n, arr, sumSubset);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // n is size of arr
        ArrayList<Integer> sumSubset = new ArrayList<>();
        helper(0, 0, n, arr, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
}

// Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it. So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).

// Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.

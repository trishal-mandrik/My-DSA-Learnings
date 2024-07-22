package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if(i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.removeLast();
        }
    }

    public static List < List < Integer >> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
}

//Time Complexity:O(2^n*k)
//
//Reason: Assume if all the elements in the array are unique then the no. of subsequence you will get will be O(2^n). we also add the ds to our ans when we reach the base case that will take “k”//average space for the ds.
//
//Space Complexity:O(k*x)
//
//Reason: if we have x combinations then space will be x*k where k is the average length of the combination.

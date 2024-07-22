package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {
    private void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombination(ind, arr, target - arr[ind], ans, ds);
            ds.removeLast();
        }
        findCombination(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}

//Time Complexity: O(2^t * k) where t is the target, k is the average length
//
//Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)
//
//Why not (2^n) but (2^t) (where n is the size of an array)?
//
//Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.
//
//Space Complexity: O(k*x), k is the average length and x is the no. of combinations


package MaximumSumofNonAdjacentElements;

import java.util.ArrayList;

public class MaximumSumOfNonAdjacentElementsRecursion {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        return solve(nums, nums.size() - 1);
    }

    static int solve(ArrayList<Integer> nums, int ind) {
        if (ind == 0) return nums.get(ind);
        if (ind < 0) return 0;

        int pick = nums.get(ind) + solve(nums, ind - 2);
        int notPick = solve(nums, ind - 1);

        return Math.max(pick, notPick);
    }
}

//TC: O(2^N)
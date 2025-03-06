package MaximumSumofNonAdjacentElements;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElementsMemoization {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, -1);
        return solve(nums, nums.size() - 1, dp);
    }

    static int solve(ArrayList<Integer> nums, int ind, int[] dp) {
        if(ind == 0) return nums.get(ind);
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int pick = nums.get(ind) + solve(nums, ind - 2, dp);
        int notPick = solve(nums, ind - 1, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}

//TC: O(N);
//SC: O(N) + O(N);

package SubsetSumEqualToK;

import java.util.Arrays;

public class Memoization {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        int[][] dp = new int[n][k + 1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(n - 1, k, arr, dp);
    }

    private static boolean solve(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return (arr[0] == target);

        // If the result for this subproblem has already been calculated, return it
        if (dp[index][target] != -1)
            return dp[index][target] != 0;

        boolean notTake = solve(index - 1, target, arr, dp);
        boolean take = false;

        if (target >= arr[index])
            take = solve(index - 1, target - arr[index], arr, dp);

        dp[index][target] = notTake || take ? 1 : 0;
        return take || notTake;
    }
}

// TC: O(N * target)
// SC: O(N * target) + O(N)

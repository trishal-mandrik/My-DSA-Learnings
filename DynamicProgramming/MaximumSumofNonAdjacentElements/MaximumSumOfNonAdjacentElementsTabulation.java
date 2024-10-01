package MaximumSumofNonAdjacentElements;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElementsTabulation {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums, int n) {
        // Write your code here.
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n, nums, dp);
    }

    private static int solve(int n, ArrayList<Integer> nums, int[] dp) {
        // Initialize the dp array with the first element of the input array.
        dp[0] = nums.getFirst();

        // Iterate through the input array to fill the dp array.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int pick = nums.get(i);

            // If there are at least two elements before the current element, add the value from dp[i-2].
            if (i > 1)
                pick += dp[i - 2];

            // The non-pick option is to use the maximum sum from the previous element.
            int nonPick = dp[i - 1];

            // Store the maximum of the two options in the dp array for the current index.
            dp[i] = Math.max(pick, nonPick);
        }

        // The final element of the dp array contains the maximum possible sum.
        return dp[n - 1];
    }
}

//TC: O(N);
//SC: O(N);

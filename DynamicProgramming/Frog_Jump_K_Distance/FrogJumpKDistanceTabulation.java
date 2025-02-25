package Frog_Jump_K_Distance;

import java.util.Arrays;

public class FrogJumpKDistanceTabulation {
    static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                } else {
                    break;
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }

    static int solve(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n, height, dp, k);
    }

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k));
    }
}

//TC: O(N * K)
//SC: O(N)

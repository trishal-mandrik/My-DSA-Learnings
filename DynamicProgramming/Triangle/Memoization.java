package Triangle;

import java.util.Arrays;

public class Memoization {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int[][] dp = new int[n][n];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return getMinimumPathSum(0, 0, n, triangle, dp);
    }

    static int getMinimumPathSum(int i, int j, int n, int[][] triangle, int[][] dp) {
        if (i == n - 1) return triangle[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j] + getMinimumPathSum(i + 1, j, n, triangle, dp);
        int diagonal = triangle[i][j] + getMinimumPathSum(i + 1, j + 1, n, triangle, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }
}

//TC: O(N * N)
//SC : O(N * N)
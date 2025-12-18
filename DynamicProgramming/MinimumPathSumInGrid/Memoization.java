package MinimumPathSumInGrid;

import java.util.Arrays;

public class Memoization {
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] it : dp) Arrays.fill(it, -1);
        return getMinimumPathSum(n - 1, m - 1, grid, dp);
    }

    private static int getMinimumPathSum(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);
        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + getMinimumPathSum(i - 1, j, grid, dp);
        int left = grid[i][j] + getMinimumPathSum(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
}

//Time Complexity: O(N*M)
//Reason: At max, there will be N*M calls of recursion.
//
//Space Complexity: O((M-1)+(N-1)) + O(N*M)
//Reason: We are using a recursion stack space: O((M-1)+(N-1)), here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.

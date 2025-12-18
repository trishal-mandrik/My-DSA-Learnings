package GridUniquePaths;

import java.util.Arrays;

public class GridUniquePathsMemoization {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return getPathsCount(m - 1, n - 1, dp);
    }

    static int getPathsCount(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = getPathsCount(i - 1, j, dp);
        int left = getPathsCount(i, j - 1, dp);

        return dp[i][j] = up + left;
    }
}


/*
 TC: O(m * n)
 SC: O((m-1) + (n-1)) + O(m * n) -> path length + DP array
*/

package Minimum_Maximum_FallingPathSum;

import java.util.Arrays;

public class Memoization {
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = getMaxPathSum(n - 1, j, m, matrix, dp);
            maxi = Math.max(maxi, ans);
        }
        return maxi;
    }

    static int getMaxPathSum(int i, int j, int m, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);

        if (i == 0)
            return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + getMaxPathSum(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxPathSum(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxPathSum(i - 1, j + 1, m, matrix, dp);

        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
}

package Minimum_Maximum_FallingPathSum;

public class Tabulation {
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = matrix[i][j] + dp[i - 1][j];
                int ld = matrix[i][j];
                int rd = matrix[i][j];

                if (j > 0) {
                    ld = ld + dp[i - 1][j - 1];
                } else {
                    ld = ld + (int) Math.pow(-10, 9);
                }

                if (j < m - 1) {
                    rd = rd + dp[i - 1][j + 1];
                } else {
                    rd = rd + (int) Math.pow(-10, 9);
                }
                dp[i][j] = Math.max(u, Math.max(ld, rd));
            }
        }
        int maxi = dp[n - 1][0];

        for (int j = 1; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }
        return maxi;
    }
}

// TC: O(N * M) + O(M)
// SC: O(N * M)
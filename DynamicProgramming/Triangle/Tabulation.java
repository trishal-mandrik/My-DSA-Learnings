package Triangle;

public class Tabulation {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int d = triangle[i][j] + dp[i + 1][j];
                int dg = triangle[i][j] + dp[i + 1][j + 1];

                dp[i][j] = Math.min(d, dg);
            }
        }

        return dp[0][0];
    }
}

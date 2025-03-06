package MinimumPathSumInGrid;

import java.util.Arrays;

public class Tabulation {
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != -1) continue;
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }

                int down = 0, right = 0;
                if (i > 0) down = grid[i][j] + dp[i - 1][j];
                else
                    down += (int) Math.pow(10, 9);
                if (j > 0) right = grid[i][j] + dp[i][j - 1];
                else
                    right += (int) Math.pow(10, 9);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[n - 1][m - 1];
    }
}

//Time Complexity: O(N*M)
//Reason: There are two nested loops
//
//Space Complexity: O(N*M)
//Reason: We are using an external array of size ‘N*M’.

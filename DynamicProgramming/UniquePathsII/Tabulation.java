package UniquePathsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Tabulation {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        int[][] dp = new int[n][m];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return getPathsCount(n, m, mat, dp);
    }

    private static int getPathsCount(int n, int m, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        // Loop through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                // Base condition: If we are at the top-left cell (0, 0), there's one way to reach it.
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];

                // Store the total number of ways to reach the current cell in the DP array
                dp[i][j] = up + left;
            }
        }
        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return dp[n - 1][m - 1];
    }
}

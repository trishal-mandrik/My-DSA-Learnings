package UniquePathsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Memoization {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        //    matrix given is N * M
        int[][] dp = new int[n][m];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return getPathsCount(n - 1, m - 1, mat, dp);
    }

    static int getPathsCount(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if (i >= 0 && j >= 0 && mat.get(i).get(j) == -1) {
            return 0;
        }
        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int up = getPathsCount(i - 1, j, mat, dp);
        int left = getPathsCount(i, j - 1, mat, dp);

        return dp[i][j] = up + left;
    }
}

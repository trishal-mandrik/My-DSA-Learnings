package MinimumPathSumInGrid;

public class Recursive {
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;
        return getMinimumPathSum(n - 1, m - 1, grid);
    }

    private static int getMinimumPathSum(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);

        int up = grid[i][j] + getMinimumPathSum(i - 1, j, grid);
        int left = grid[i][j] + getMinimumPathSum(i, j - 1, grid);

        return Math.min(up, left);
    }
}

//Time Complexity: O(N*M)
//Reason: At max, there will be N*M calls of recursion.
//
//Space Complexity: O((M-1)+(N-1)) + O(N*M)
//Reason: We are using a recursion stack space: O((M-1)+(N-1)), here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.

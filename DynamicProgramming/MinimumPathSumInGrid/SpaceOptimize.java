package MinimumPathSumInGrid;

public class SpaceOptimize {
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                    continue;
                }

                int down = 0, right = 0;
                down = grid[i][j];
                if (i > 0) down += prev[j];
                else
                    down += (int) Math.pow(10, 9);

                right = grid[i][j];
                if (j > 0) right += curr[j - 1];
                else
                    right += (int) Math.pow(10, 9);

                curr[j] = Math.min(down, right);
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}

//Time Complexity: O(M*N)
//Reason: There are two nested loops
//
//Space Complexity: O(N)
//Reason: We are using an external array of size ‘N’ to store only one row.

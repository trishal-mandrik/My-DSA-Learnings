package Minimum_Maximum_FallingPathSum;

public class SpaceOptimize {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];

        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if (j > 0) {
                    ld += prev[j - 1];
                } else {
                    ld += (int) -1e9;
                }

                int rd = matrix[i][j];
                if (j < m - 1) {
                    rd += prev[j + 1];
                } else {
                    rd += (int) -1e9;
                }
                curr[j] = Math.max(up, Math.max(ld, rd));
            }
            prev = curr;
        }

        int maxi = prev[0];

        for (int j = 1; j < m; j++) {
            maxi = Math.max(maxi, prev[j]);
        }
        return maxi;
    }
}

// TC: O(N * M) + O(M)
// SC: O(M)

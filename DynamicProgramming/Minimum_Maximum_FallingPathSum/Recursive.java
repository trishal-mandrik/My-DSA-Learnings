package Minimum_Maximum_FallingPathSum;

public class Recursive {
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = getMaxPathSum(n - 1, j, m, matrix);
            maxi = Math.max(maxi, ans);
        }
        return maxi;
    }

    static int getMaxPathSum(int i, int j, int m, int[][] matrix) {
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);

        if (i == 0)
            return matrix[0][j];

        int up = matrix[i][j] + getMaxPathSum(i - 1, j, m, matrix);
        int leftDiagonal = matrix[i][j] + getMaxPathSum(i - 1, j - 1, m, matrix);
        int rightDiagonal = matrix[i][j] + getMaxPathSum(i - 1, j + 1, m, matrix);

        return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
}

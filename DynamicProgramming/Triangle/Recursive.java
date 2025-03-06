package Triangle;

import java.util.Arrays;

public class Recursive {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        return getMinimumPathSum(0, 0, n, triangle);
    }

    static int getMinimumPathSum(int i, int j, int n, int[][] triangle) {
        if (i == n - 1) return triangle[i][j];

        int down = triangle[i][j] + getMinimumPathSum(i + 1, j, n, triangle);
        int diagonal = triangle[i][j] + getMinimumPathSum(i + 1, j + 1, n, triangle);

        return Math.min(down, diagonal);
    }
}

//TC: O(2 ^ N)
//SC: O(N)
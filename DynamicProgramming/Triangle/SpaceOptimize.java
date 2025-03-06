package Triangle;

public class SpaceOptimize {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int[] front = new int[n];


        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] cur = new int[n];

            for (int j = i; j >= 0; j--) {
                int d = triangle[i][j] + front[j];
                int dg = triangle[i][j] + front[j + 1];

                cur[j] = Math.min(d, dg);
            }
            front = cur;
        }
        return front[0];
    }
}

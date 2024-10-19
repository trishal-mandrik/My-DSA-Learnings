package GridUniquePaths;

public class GridUniquePathsSpaceOptimize {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        // Create an array to store the results for the previous row
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0) up = prev[j];
                if (j > 0) left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}

/*
Time Complexity: O(M*N)

Reason: There are two nested loops

Space Complexity: O(N)

Reason: We are using an external array of size ‘N’ to store only one row.
*/

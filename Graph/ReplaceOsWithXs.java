package Graph;

/* public static int[][] deepCopy2DArray(int[][] originalArray) {
    int rows = originalArray.length;
    int cols = originalArray[0].length;

    int[][] copiedArray = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
        System.arraycopy(originalArray[i], 0, copiedArray[i], 0, cols);
    }

    return copiedArray;
}
 */
public class ReplaceOsWithXs {
    char[][] fill(int n, int m, char[][] a) {
        // code here
        boolean[][] vis = new boolean[n][m];
        char[][] mat = new char[n][m];

        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, mat[i], 0, m);
        }

        for (int j = 0; j < m; j++) {
            // first row
            if (!vis[0][j] && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, n, m);
            }

            // last row
            if (!vis[n - 1][j] && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            // first col
            if (!vis[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, n , m);
            }

            // last col
            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, n , m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }

    private void dfs(int row, int col, boolean[][] vis, char[][] mat, int n, int m) {
        vis[row][col] = true;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, n, m);
            }
        }
    }
}

//TC: O(n) + O(m) + O(n * m) * 4 = O(n * m)
//SC: O(n * m)
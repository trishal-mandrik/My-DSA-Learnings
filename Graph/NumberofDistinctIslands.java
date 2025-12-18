package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberofDistinctIslands {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        HashSet<ArrayList<String>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i, j, vis, grid, arr, i, j, n, m);
                    st.add(arr);
                }
            }
        }
        return st.size();
    }

    private void dfs(int row, int col, boolean[][] vis, int[][] grid, ArrayList<String> arr, int row0, int col0, int n, int m) {
        vis[row][col] = true;
        arr.add(toString(row - row0, col - col0));

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, arr, row0, col0, n, m);
            }
        }
    }

    private String toString(int r, int c) {
        return r + " " + c;
    }
}

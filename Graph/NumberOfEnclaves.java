package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    int numberOfEnclaves(int[][] grid) {
        // Your code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        Queue<RowColPair> q = new LinkedList<>();
        int landCells = 0;

        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, ans[i], 0, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        vis[i][j] = true;
                        q.add(new RowColPair(i, j));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    q.add(new RowColPair(nrow, ncol));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1)
                    landCells++;
            }
        }
        return landCells;
    }
}

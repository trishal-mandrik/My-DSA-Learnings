package Graph;

import java.util.LinkedList;
import java.util.Queue;

class RowColTimePair {
    int row, col, time;

    public RowColTimePair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<RowColTimePair> q = new LinkedList<>();

        int[][] vis = new int[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if cell contains rotten orange
                if (grid[i][j] == 2) {
                    q.add(new RowColTimePair(i, j, 0));
                    // mark as visited (rotten) in visited array
                    vis[i][j] = 2;
                }
                // if not rotten
                else vis[i][j] = 0;

                // count fresh oranges
                if (grid[i][j] == 1) cntFresh++;
            }
        }

        int tm = 0;
        //delta row and delta col
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int cnt = 0;

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            tm = Integer.max(time, tm);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new RowColTimePair(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return tm;
    }
}

//TC: O(n * m)
//SC: O(n * m)

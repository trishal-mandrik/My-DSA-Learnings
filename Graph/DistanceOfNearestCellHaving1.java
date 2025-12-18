package Graph;

import java.util.LinkedList;
import java.util.Queue;

class RowColDistPair {
    int row, col, dist;

    public RowColDistPair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class DistanceOfNearestCellHaving1 {
    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[][] distance = new int[n][m];

        Queue<RowColDistPair> q = new LinkedList<>();
        // traverse the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // start BFS if cell contains 1
                if (grid[row][col] == 1) {
                    vis[row][col] = true;
                    q.add(new RowColDistPair(row, col, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            distance[row][col] = dist;
            q.remove();

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.add(new RowColDistPair(nrow, ncol, dist + 1));
                }
            }
        }
        // return distance matrix
        return distance;
    }
}

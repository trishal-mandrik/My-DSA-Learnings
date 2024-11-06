package Graph;

import java.util.LinkedList;
import java.util.Queue;

class RowColPair {
    int first, second;

    public RowColPair(int first, int second) {
        this.second = second;
        this.first = first;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }

    private void bfs(int ro, int co, boolean[][] vis, char[][] grid) {
        vis[ro][co] = true;
        Queue<RowColPair> q = new LinkedList<>();
        q.add(new RowColPair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

//            traverse in the neighbours and mark them if its a land
            for (int delrow = -1; delrow <= 1 ; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        q.add(new RowColPair(nrow, ncol));
                    }
                }
            }
        }
    }
}

//SC: O(N^2)
//TC: O(N^2)
package Graph;


import java.util.LinkedList;
import java.util.Queue;

//using Dijkstra and queue
public class ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if (source[0] == destination[0] && source[1] == destination[1]) return 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }
        // keep distance at first in pair
        Queue<RowColDistPair> q = new LinkedList<>();

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        dist[source[0]][source[1]] = 0;
        q.add(new RowColDistPair(source[0], source[1], 0));

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int distance = q.peek().dist;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && distance + 1 < dist[newRow][newCol]) {
                    dist[newRow][newCol] = distance + 1;
                    if (newRow == destination[0] && newCol == destination[1]) return distance + 1;
                    q.add(new RowColDistPair(newRow, newCol, dist[newRow][newCol]));
                }
            }
        }
        return -1;
    }
}

package Graph;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class DistRowColPair {
    int row, col, dist;

    public DistRowColPair(int dist, int row, int col) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class PathWithMinimumEffort {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int[][] dist = new int[rows][columns];
        // Fill each row with 2
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], (int) (1e9));
        }

        dist[0][0] = 0;
        PriorityQueue<DistRowColPair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
        pq.add(new DistRowColPair(0, 0, 0));

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int row = pq.peek().row;
            int col = pq.peek().col;
            int diff = pq.peek().dist;
            pq.remove();

            if (row == rows - 1 && col == columns - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);

                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new DistRowColPair(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }
}

// TC: O(n * m * 4 * log(n*m))
// SC: O(n * m)
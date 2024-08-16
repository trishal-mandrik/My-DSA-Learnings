package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBipartiteUsingDFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] color = new int[V];

        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!detectBipartite(i, adj, color, 0)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean detectBipartite(int i, ArrayList<ArrayList<Integer>> adj, int[] color, int col) {
        color[i] = col;

        for (Integer it: adj.get(i)){
            if (color[it] == -1) {
                if(!detectBipartite(it, adj, color, 1 - col)) return false;
            } else if (color[it] == color[i]) {
                return false;
            }
        }
        return true;
    }
}

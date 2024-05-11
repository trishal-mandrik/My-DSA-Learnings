package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private boolean detectBipartite(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int color[] = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!detectBipartite(i, adj, color)) {
                    return false;
                }
            }

        }
        return true;
    }
}

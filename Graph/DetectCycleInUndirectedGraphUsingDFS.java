package Graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphUsingDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, vis, adj, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int parent) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                detectCycle(it, vis, adj, node);
            } else if (parent != it) {
                return true;
            }
        }
        return false;
    }
}

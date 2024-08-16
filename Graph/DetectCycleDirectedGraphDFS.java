package Graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraphDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, adj, vis, pathVis)) return true;
            } else if (pathVis[it]) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}

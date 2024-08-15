package Graph;

import java.util.ArrayList;

class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, storeDfs);
            }
        }
        return storeDfs;
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node);
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, storeDfs);
            }
        }
    }
}

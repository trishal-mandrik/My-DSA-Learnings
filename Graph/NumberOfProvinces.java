package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

//        to change adjacency matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, boolean[] vis) {
        vis[node] = true;
        for (Integer it : adjLs.get(node)) {
            if (!vis[it]) {
                dfs(it, adjLs, vis);
            }
        }
    }
}

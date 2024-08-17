package Graph;
import java.util.*;

public class EventualSafeStates {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        for (int i = 0; i < V; i++) {
            if (check[i]) safeNodes.add(i);
        }
        return safeNodes;
    }

    private boolean dfsCheck(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;

        for (Integer it: adj.get(node)){
            if (!vis[it]){
                if (dfsCheck(it, adj, vis, pathVis, check))
                    return true;
            } else if (pathVis[it]) {
                return true;
            }
        }
        check[node] = true; // mark as safe
        pathVis[node] = false;
        return false;
    }
}

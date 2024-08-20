package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class VDistPair {
    int first, second;

    public VDistPair(int first, int second) {
        this.second = second;
        this.first = first;
    }
}

public class ShortestPathInUndirectedGraph {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<VDistPair> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new VDistPair(src, 0));

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int distance = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) {
                if (distance + 1 < dist[it]) {
                    dist[it] = distance + 1;
                    q.add(new VDistPair(it, dist[it]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

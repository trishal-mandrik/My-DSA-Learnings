package Graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreeUsingPrims {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<DistanceNodePair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        pq.add(new DistanceNodePair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node]) continue;

            vis[node] = true;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];
                if (!vis[adjNode]) {
                    pq.add(new DistanceNodePair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}

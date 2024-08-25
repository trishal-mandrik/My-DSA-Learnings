package Graph;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        //  Code Here.
        ArrayList<ArrayList<DistanceNodePair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new DistanceNodePair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new DistanceNodePair(edges[i][2], edges[i][0]));
        }

        PriorityQueue<DistanceNodePair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new DistanceNodePair(0, 1));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.remove();

            for (DistanceNodePair it : adj.get(node)) {
                int adjNode = it.node;
                int edw = it.distance;

                if (distance + edw < dist[adjNode]) {
                    dist[adjNode] = distance + edw;
                    pq.add(new DistanceNodePair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        path.add(dist[n]);  // ques updated
        Collections.reverse(path);
        return path;
    }
}

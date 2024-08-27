package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class DistanceNodeStopsPair {
    int distance, node, stops;

    public DistanceNodeStopsPair(int _dis, int _node, int _stops) {
        distance = _dis;
        node = _node;
        stops = _stops;
    }
}

public class CheapestFlightsWithinKStops {
    public int CheapestFLight(int n, int[][] flights, int src, int dst, int k) {
        // Code here
        int[] dist = new int[n];
        Queue<DistanceNodeStopsPair> q = new LinkedList<>();
        ArrayList<ArrayList<DistanceNodePair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new DistanceNodePair(flights[i][2], flights[i][1]));
        }

        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;

        q.add(new DistanceNodeStopsPair(0, src, 0));

        while (!q.isEmpty()) {
            int cost = q.peek().distance;
            int node = q.peek().node;
            int stops = q.peek().stops;
            q.remove();

            if (stops > k) continue;
            for (DistanceNodePair it: adj.get(node)){
                int adjNode = it.node;
                int edw = it.distance;

                if(cost + edw < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edw;
                    q.add(new DistanceNodeStopsPair(cost + edw, adjNode, stops + 1));
                }
            }
        }
        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }
}

// TC: O(E) = O(flights.size())

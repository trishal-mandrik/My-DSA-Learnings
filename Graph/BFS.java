package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
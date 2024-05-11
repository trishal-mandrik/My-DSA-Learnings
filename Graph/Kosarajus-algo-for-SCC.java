package Graph;

import java.util.ArrayList;
import java.util.Stack;


class Solution {
    void topoDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                topoDFS(it, adj, vis, st);
            }
        }

        st.push(node);
    }

    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adjT);
            }
        }
    }

    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                topoDFS(i, adj, vis, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for (Integer it : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == false) {
                scc++;
                dfs(node, vis, adjT);
            }
        }
        return scc;
    }
}

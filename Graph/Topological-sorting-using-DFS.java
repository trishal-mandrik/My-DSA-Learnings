package Graph;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                findTopoSort(i, adj, vis, st);
            }
        }

        int topo[] = new int[V];
        int ind = 0;
        while (!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        return topo;
    }

    static void findTopoSort(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> st) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                findTopoSort(it, adj, vis, st);
            }
        }
        st.push(node);
    }
}
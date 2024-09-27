package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // add your code here
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        int[] topo = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (findTopoSort(i, adj, vis, st, topo, pathVis)) return new int[]{};
            }
        }

        int ind = 0;
        while (!st.isEmpty()) {
            topo[ind++] = st.pop();
        }

        return topo;
    }

    static boolean findTopoSort(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st, int[] topo, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (findTopoSort(it, adj, vis, st, topo, pathVis)) return true;
            } else if (pathVis[it]) return true;
        }
        pathVis[node] = false;
        st.add(node);
        return false;
    }
}

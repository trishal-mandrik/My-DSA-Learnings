package Recursion;

import java.util.List;

public class MColoring {
    public boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) {
        int n = G.length;
        return solve(i, G, color, m, n);
    }

    private boolean solve(int node, List<Integer>[] G, int[] color, int m, int n) {
        if (node == n) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, m, n)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int node, List<Integer>[] G, int[] color, int col) {
        for (int it : G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }
}

//Time Complexity: O(N^M) (n raised to m)
//
//Space Complexity: O(N)

package Recursion.RatInAMaze;

import java.util.ArrayList;

public class RatInAMazeApproachOne {
    public ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1) solve(0, 0, m, n, vis, ans, "");
        return ans;
    }

    private void solve(int i, int j, int[][] m, int n, int[][] vis, ArrayList<String> ans, String move) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && m[i + 1][j] == 1) {
            vis[i][j] = 1;
            solve(i + 1, j, m, n, vis, ans, move + 'D');
            vis[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && m[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, m, n, vis, ans, move + 'L');
            vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && m[i][j + 1] == 1) {
            vis[i][j] = 1;
            solve(i, j + 1, m, n, vis, ans, move + 'R');
            vis[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && m[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, m, n, vis, ans, move + 'U');
            vis[i][j] = 0;
        }
    }
}

//Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
//
//Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
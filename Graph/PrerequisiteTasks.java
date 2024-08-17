package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrerequisiteTasks {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        int[] indegree = new int[N];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(N);

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < P; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return (cnt == N);
    }
}

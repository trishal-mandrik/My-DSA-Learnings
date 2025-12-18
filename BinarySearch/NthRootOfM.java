public class NthRootOfM {
    // return 1 if == m
    // return 0 if < m
    // return 2 if > m
    static int isPossible(int mid, int m, int n) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midN = isPossible(mid, m, n);
            if (midN == 1) return mid;
            else if (midN == 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

// TC: O(logM * N)
// SC: O(1)

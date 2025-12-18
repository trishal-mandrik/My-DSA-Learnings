package FindNthRootOfM;

public class Optimal {
    public int nthRoot(int n, int m) {
        // Code here
        if (m == 0) return 0;
        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long midN = multiplier(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    long multiplier(int mid, int n, int m) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= mid;
            if (result > m) return 2;
        }
        if (result == m) return 1;
        return 0;
    }
}

// TC: O(logM * N) where M is the range of search space and N is the number of multiplications
// SC: O(1)

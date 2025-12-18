package SquareRoot;

public class Optimal {
    int floorSqrt(int x) {
        // code here
        if (x == 0) return 0;
        int ans = 1;
        long low = 1, high = x / 2;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == x) {
                ans = (int) mid;
                return ans;
            } else if (mid * mid > x) {
                high = mid - 1;
            } else {
                ans = (int) mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}

// TC: O(logN)
// SC: O(1)

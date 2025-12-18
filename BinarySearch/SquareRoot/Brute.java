package SquareRoot;

public class Brute {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int ans = 1;
        for (long i = 1; i <= x / 2; i++) {
            if ((i * i) <= x) {
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }
}

// TC: O(N)
// SC: O(1)

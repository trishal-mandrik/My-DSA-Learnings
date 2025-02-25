package Fibonacci;

public class Memoization {
    int f(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }
}

//TC: O(N)
//SC: O(N) + O(N)
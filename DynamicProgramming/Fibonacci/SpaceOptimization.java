package Fibonacci;

public class SpaceOptimization {
    int f(int n) {
        int prev2 = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

//TC: O(N)
//SC: O(1)

package Frog_Jump_K_Distance;

public class FrogJumpKDistanceRecursion {
    int solveUtil(int ind, int[] height, int k) {
        return f(ind, height, k);
    }

    int f(int ind, int[] height, int k) {
        if (ind == 0) return 0;
        int min_steps = Integer.MIN_VALUE;
//        int left = f(ind - 1, height, k) + Math.abs(height[ind] - height[ind - 1]);

        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = f(ind - j, height, k) + Math.abs(height[ind] - height[ind - j]);
                min_steps = Math.min(jump, min_steps);
            }
        }
        return min_steps;
    }

    int frogJump(int[] height, int k, int n) {
        return solveUtil(n-1, height, k);
    }
}

//TC: O(N * k);
//SC: O(N) + O(N);

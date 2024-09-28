package Frog_Jump;

public class FrogJumpRecursion {
    public int frogJump(int n, int[] heights) {

        // Write your code here..
        return f(n - 1, heights);

    }

    int f(int ind, int[] arr) {
        if (ind == 0) return 0;

        int left = f(ind - 1, arr) + Math.abs(arr[ind] - arr[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = f(ind - 2, arr) + Math.abs(arr[ind] - arr[ind - 2]);
        return Math.min(left, right);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrogJumpRecursion {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));

        return solve(n - 1, heights, dp);
    }

    public static int solve(int idx, int heights[], List<Integer> dp) {
        if (idx == 0) return 0;
        if (dp.get(idx) != -1) return dp.get(idx);
        int left = solve(idx - 1, heights, dp) + Math.abs(heights[idx] - heights[idx - 1]);
        int right = Integer.MAX_VALUE;

        if (idx > 1) right = solve(idx - 2, heights, dp) + Math.abs(heights[idx] - heights[idx - 2]);
        dp.set(idx, Math.min(left, right));
        return dp.get(idx);
    }
}
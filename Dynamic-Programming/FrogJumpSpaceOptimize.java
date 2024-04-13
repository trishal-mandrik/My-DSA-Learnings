public class FrogJumpSpaceOptimize {
    public static int frogJump(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev1 + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;

            if(i > 1) ss = prev2 + Math.abs(heights[i] - heights[i-2]);
            int currIdx = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = currIdx;
        }
        return prev1;
    }
}

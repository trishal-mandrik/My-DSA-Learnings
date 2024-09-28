package Frog_Jump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrogJumpTabulation {
    public static int frogJump(int n, int[] heights) {

        // Write your code here..
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 1; i < n; i++) {
            int fs = dp.get(i - 1) + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;

            if (i > 1) ss = dp.get(i - 2) + Math.abs(heights[i] - heights[i - 2]);

            dp.set(i, Math.min(fs, ss));
        }
        return dp.get(n - 1);
    }
}

//TC: O(N)
//SC: O(N)
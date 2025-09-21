package AggressiveCows;

import java.util.Arrays;

public class Optimal {
    static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1, last = stalls[0];

        for (int stall : stalls) {
            if (stall - last >= dist) {
                cntCows++;
                last = stall;
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int size = stalls.length;
        int low = 1, high = stalls[size - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlace(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
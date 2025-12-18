package AggressiveCows;

import java.util.Arrays;

public class Brute {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int limit = stalls[n - 1] - stalls[0];

        for (int i = 0; i <= limit; i++) {
            if (!canWePlace(stalls, i, k)) {
                return i - 1;
            }
        }
        return limit;
    }

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
}

//Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
//        Reason: O(NlogN) for sorting the array. We are using a loop from 1 to max(stalls[])-min(stalls[]) to check all possible distances. Inside the loop, we are calling canWePlace() function for each distance. Now, inside the canWePlace() function, we are using a loop that runs for N times.
//
//Space Complexity: O(1) as we are not using any extra space to solve this problem.
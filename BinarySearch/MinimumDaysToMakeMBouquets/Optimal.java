package MinimumDaysToMakeMBouquets;

import static MinimumDaysToMakeMBouquets.Brute.isPossible;

public class Optimal {
    public int minDaysBloom(int[] arr, int k, int m) {
        long minFlowers = (long) k * m;
        int n = arr.length;
        if(minFlowers > n) return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i: arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        int low = min, high = max;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(arr, mid, k, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

// TC: O(N * log(max - min)) where N is the number of flowers
// SC: O(1)

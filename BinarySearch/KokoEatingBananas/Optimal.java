package KokoEatingBananas;

import java.util.Arrays;

import static KokoEatingBananas.Brute.calculateHours;

public class Optimal {
    public int kokoEat(int[] arr, int k) {
        int max = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int low = 1;
        int high = max, ans = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalH = calculateHours(arr, mid);

            if (totalH <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

// TC: O(N * log(max(arr))) where N is the number of piles and M is the maximum number of bananas in a pile
// SC: O(1)

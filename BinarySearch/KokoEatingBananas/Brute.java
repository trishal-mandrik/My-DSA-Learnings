package KokoEatingBananas;

import java.util.Arrays;

public class Brute {
    public int kokoEat(int[] arr, int k) {
        // code here
        int max = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;

        for (int bananas = 1; bananas <= max; bananas++) {
            int totalH = calculateHours(arr, bananas);
            if (totalH <= k) {
                return bananas;
            }
        }
        return max;
    }

    static int calculateHours(int[] arr, int bananasPerHour) {
        int totalH = 0;
        for (int j : arr) {
            totalH += Math.ceil((double) j / (double) bananasPerHour);
        }
        return totalH;
    }
}

// TC: O(N * max(arr)) where N is the number of piles and M is the maximum number of bananas in a pile
// SC: O(1)

package MinimumDaysToMakeMBouquets;

public class Brute {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        long minFlowers = (long) k * m;
        int n = arr.length;
        if (minFlowers > n) return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        for (int days = min; days <= max; days++) {
            if (isPossible(arr, days, k, m)) {
                return days;
            }
        }
        return -1;
    }

    static boolean isPossible(int[] arr, int days, int k, int m) {
        int cnt = 0;
        int totalB = 0;

        for (int i : arr) {
            if (i <= days) {
                cnt++;
            } else {
                totalB += cnt / k;
                cnt = 0;
            }
        }
        totalB += cnt / k;
        return totalB >= m;
    }
}

// TC: O(N * (max - min)) where N is the number of flowers
// SC: O(1)

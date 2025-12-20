package CapacityToShipPackagesWithinDDays;

import java.util.Arrays;

import static CapacityToShipPackagesWithinDDays.Brute.findDaysNeeded;

public class Optimal {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        int maxi = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int sum = Arrays.stream(arr).sum();

        int low = maxi, high = sum, ans = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int daysNeeded = findDaysNeeded(arr, mid);

            if (daysNeeded <= d) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}


// TC: O(N * log(sum(arr))) where N is the number of packages
// SC: O(1)
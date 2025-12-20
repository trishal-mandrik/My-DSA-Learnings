package CapacityToShipPackagesWithinDDays;

import java.util.Arrays;

public class Brute {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int maxi = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int sum = Arrays.stream(arr).sum();

        for (int cap = maxi; cap <= sum; cap++) {
            int daysNeeded = findDaysNeeded(arr, cap);
            if (daysNeeded <= d) return cap;
        }
        return sum;
    }

    static int findDaysNeeded(int[] arr, int cap) {
        int days = 1, load = 0;

        for(int weight: arr) {
            if (load + weight > cap) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }
}

// TC: O(N * sum(arr)) where N is the number of packages
// SC: O(1)

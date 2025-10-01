package SmallestDivisor;

import java.util.Arrays;

public class Brute {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int maxi = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;

        for(int d = 1; d <= maxi; d++) {
            if(isPossible(arr, d, k)) return d;
        }
        return 1;
    }

    static boolean isPossible(int[] arr, int divisor, int k) {
        int sum = 0;

        for(int i: arr) {
            sum += Math.ceil((double) i / (double) divisor);
        }
        return sum <= k;
    }
}

// TC: O(N * max(arr)) where N is the number of elements in the array
// SC: O(1)

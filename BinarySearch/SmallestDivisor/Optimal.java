package SmallestDivisor;

import java.util.Arrays;

import static SmallestDivisor.Brute.isPossible;

public class Optimal {
    int smallestDivisor(int[] arr, int k) {
        int low = 1, high = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

// TC: O(N * log(max(arr))) where N is the number of elements in the array
// SC: O(1)

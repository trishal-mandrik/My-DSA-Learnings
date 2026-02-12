package PainterPartitionAndSplitArray;

import java.util.Arrays;

public class Optimal {
    public int minTime(int[] arr, int k) {
        // code here
        if (arr.length < k) {
            return -1;
        }

        int max = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int sum = Arrays.stream(arr).sum();

        int low = max, high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countPainters(arr, mid) > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int countPainters(int[] arr, int length) {
        int painterCount = 1;
        int lengthSum = 0;

        for (int j : arr) {
            if (lengthSum + j <= length) {
                lengthSum += j;
            } else {
                painterCount++;
                lengthSum = j;
            }
        }
        return painterCount;
    }
}

// TC: O(N * log(sum(arr) - max(arr) + 1) where N is the number of boards
// SC: O(1)
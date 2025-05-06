package SlidingWindow.MaxSumOfArraySizeK;

public class Solution {
    public int findMax(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = k - 1;
        int maxSum = 0;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            maxSum += arr[i];
        }

        while (r < n - 1) {
            sum -= arr[l];
            l++;
            r++;
            sum += arr[r];

            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}

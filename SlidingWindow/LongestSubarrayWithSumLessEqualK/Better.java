package SlidingWindow.LongestSubarrayWithSumLessEqualK;

public class Better {
    public int longestSubarrayWithSumLessEqualK(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, sum = 0;

        while (r < arr.length) {
            sum += arr[r];

            while (sum > k) {
                sum -= arr[l];
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}

//TC: O(n + n);
//TC: O(1);

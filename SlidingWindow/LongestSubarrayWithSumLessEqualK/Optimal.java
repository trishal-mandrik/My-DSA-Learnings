package SlidingWindow.LongestSubarrayWithSumLessEqualK;

public class Optimal {
    public int longestSubarrayWithSumLessEqualK(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, sum = 0;

        while (r < arr.length) {
            sum += arr[r];

            if (sum > k) {
                sum -= arr[l];
                l++;
            }

            if (sum <= k)
                maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}

//TC: O(n);
//TC: O(1);

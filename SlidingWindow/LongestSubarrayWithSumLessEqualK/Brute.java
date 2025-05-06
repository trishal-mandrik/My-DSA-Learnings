package SlidingWindow.LongestSubarrayWithSumLessEqualK;

public class Brute {
    public int longestSubarrayWithSumLessEqualK(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break;
            }
        }
        return maxLen;
    }
}

//TC: O(n ^ 2);
//TC: O(1);

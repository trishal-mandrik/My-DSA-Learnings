package SlidingWindow.MaxConsecutiveOnesIII;

public class Better {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, l = 0, r = 0, zeros = 0, len;
        int n = nums.length;

        while (r < n) {
            if (nums[r] == 0) zeros++;

            while (zeros > k) {
                if (nums[l] == 0) zeros--;
                l++;
            }
            if (zeros <= k) {
                len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}

//TC: O(2N);
//SC: O(1);

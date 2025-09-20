package SlidingWindow;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return lessEqualToK(nums, k) - lessEqualToK(nums, k - 1);
    }

    int lessEqualToK(int[] nums, int k) {
        if (k < 0) return 0;

        int l = 0, r = 0, sum = 0, cnt = 0;

        while (r < nums.length) {
            sum += nums[r] % 2;

            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }
            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }
}

//TC: O(2 * 2N)
//SC: O(1)

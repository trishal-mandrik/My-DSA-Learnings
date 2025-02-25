package SlidingWindow;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return lessEqualToK(nums, goal) - lessEqualToK(nums, goal - 1);
    }

    int lessEqualToK(int[] nums, int goal) {
        if (goal < 0) return 0;

        int l = 0, r = 0, sum = 0, cnt = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
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
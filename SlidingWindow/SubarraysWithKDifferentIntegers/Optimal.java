package SlidingWindow.SubarraysWithKDifferentIntegers;

import java.util.HashMap;

public class Optimal {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return lessEqualToK(nums, k) - lessEqualToK(nums, k - 1);
    }

    int lessEqualToK(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0, n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        while (r < n) {  // N
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(nums[l], mpp.get(nums[l]) - 1);

                if (mpp.get(nums[l]) == 0)
                    mpp.remove(nums[l]);

                l++;
            }
            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }
}

//TC: O(2N)
//SC: O(1)

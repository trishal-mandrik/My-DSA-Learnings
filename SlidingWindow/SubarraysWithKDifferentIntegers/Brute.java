package SlidingWindow.SubarraysWithKDifferentIntegers;

import java.util.HashSet;

public class Brute {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int cnt = 0;
        HashSet<Integer> mpp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                mpp.add(nums[j]);

                if (mpp.size() == k) cnt++;
                else if (mpp.size() > k) {
                    mpp.clear();
                    break;
                }
            }
        }
        return cnt;
    }
}

//TC: O(N ^ 2);
//SC: O(N);

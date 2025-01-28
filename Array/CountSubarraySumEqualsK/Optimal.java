package Array.CountSubarraySumEqualsK;

import java.util.HashMap;

public class Optimal {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int preSum = 0, cnt = 0;

        for (int num : nums) {
            preSum += num;
            int remove = preSum - k;
            cnt = cnt + mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}

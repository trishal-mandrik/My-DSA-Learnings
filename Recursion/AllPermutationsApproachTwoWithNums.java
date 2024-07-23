package Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsApproachTwoWithNums {
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) {
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int index, int[] nums) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }
}

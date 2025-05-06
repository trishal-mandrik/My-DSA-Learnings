package Array.NextPermutation;

import static Array.BinaryArraySorting.swap;

public class Optimal {
    void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) { // find the breaking point
            i--;
        }

        if (i >= 0) { // breakpoint is somewhere in the array
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) { // finding next greater than nums[i]
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}

//TC: O(3N)
//SC: O(1)

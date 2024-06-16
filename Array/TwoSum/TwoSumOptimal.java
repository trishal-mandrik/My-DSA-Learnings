package Array.TwoSum;

import java.util.Arrays;

public class TwoSumOptimal {
    public static String read(int n, int[] arr, int target) {
        // Write your code here.
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            } else if (sum < target) left++;
            else right--;
        }
        return "NO";
    }
}


// TC: O(N) + O(NlogN) SC: O(1)
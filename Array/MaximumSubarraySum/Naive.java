package Array.MaximumSubarraySum;

public class Naive {
    static int maxSubarraySum(int[] arr) {
        int res = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;

            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];

                res = Math.max(currSum, res);
            }
        }
        return res;
    }
}

//TC: O(N ^ 2)
//SC: O(1)

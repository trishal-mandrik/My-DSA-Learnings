package Array.MaximumSubarraySum;

public class KadaneAlgo {
    int maxSubarraySum(int[] arr) {
        // Your code here
        int sum = 0, maxi = Integer.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;

        for (int j : arr) {
            int start = 0;
            if (sum == 0) start = j;
            sum += j;

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = j;
            }


            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
}

//TC: O(N)
//SC: O(1)

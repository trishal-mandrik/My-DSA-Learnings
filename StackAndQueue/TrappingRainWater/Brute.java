package StackAndQueue.TrappingRainWater;

public class Brute {
    public int maxWater(int[] arr) {
        // code here
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = arr[0];
        suffixMax[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) { // N
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) { // N
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            int leftmax = prefixMax[i];
            int rightmax = suffixMax[i];

            if (arr[i] < leftmax && arr[i] < rightmax) {
                total += Math.min(leftmax, rightmax) - arr[i];
            }
        }

        return total;
    }
}

//TC: O(2N) + O(N)
//SC: O(2N)
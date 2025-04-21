package Array;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceBetweenHeights {
    static int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - k < 0) continue;

            int minH = Math.min(smallest, arr[i + 1] - k);
            int maxH = Math.max(largest, arr[i] + k);
            res = Math.min(res, maxH - minH);
        }
        return res;
    }
}

//Time Complexity: O(nlogn), as we are sorting the array.
//Auxiliary Space: O(1)

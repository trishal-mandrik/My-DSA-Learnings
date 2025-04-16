package Array.KthSmallestElement;

import java.util.Arrays;

public class BySorting {
    public static int kthSmallest(Integer[] arr, int k) {
        Arrays.sort(arr);

        return arr[k - 1];
    }
}

//Time Complexity: O(N log N)
//Auxiliary Space: O(1)



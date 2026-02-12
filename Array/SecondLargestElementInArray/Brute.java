package Array.SecondLargestElementInArray;

import java.util.Arrays;

public class Brute {
    public int getSecondLargest(int[] arr) {
        // code here
        Arrays.sort(arr);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[arr.length - 1]) return arr[i];
        }
        return -1;
    }
}

// TC: O(N log N) + O(N) where N is the number of elements in the array
// SC: O(1)

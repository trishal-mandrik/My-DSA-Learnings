package Array;

import static Array.BinaryArraySorting.swap;

public class Sort0s1sAnd2s {
    public void sort012(int[] arr) {
        // code here
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) mid++;

            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
}

/*
Time Complexity: O(N), where N = size of the given array.
        Reason: We are using a single loop that can run at most N times.

Space Complexity: O(1) as we are not using any extra space.
*/

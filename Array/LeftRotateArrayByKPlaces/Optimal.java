package Array.LeftRotateArrayByKPlaces;

import Array.BinaryArraySorting;

// variation present
public class Optimal {
    public void rotate(int[] arr, int d) {
        int n = arr.length;
        if (n == 0 || d == 0) return;
        d = d % n; // In case k is greater than n

        reverseArray(arr, 0, d - 1); // O(d)
        reverseArray(arr, d, n - 1); // O(n-d)
        reverseArray(arr, 0, n - 1); // O(n)
    }

    void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            BinaryArraySorting.swap(arr, start, end);
            start++;
            end--;
        }
    }
}

// Overall TC: O(2n)
// Overall SC: O(1)
package Array.MoveZerosToEnd;

import Array.BinaryArraySorting;

public class Optimal {
    void pushZerosToEnd(int[] arr) {
        // code here
        int j = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) { // O(x) where x is the 1st index of zeros in the array
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) return;
        for (int i = j + 1; i < n; i++) { // O(n-x) where x is the 1st index of zeros in the array
            if (arr[i] != 0) {
                BinaryArraySorting.swap(arr, i, j);
                j++;
            }
        }
    }
}

// Overall TC: O(n) where n is the number of elements in the array
// Overall SC: O(1)
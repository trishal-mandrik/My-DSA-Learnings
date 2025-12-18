package Array.MoveAllNegativeElementsToEnd;

import static Array.BinaryArraySorting.swap;

public class Optimal {
    public static void segregateElements(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            if (arr[i] < 0) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (arr[i] >= 0) {
                i++;
            }
        }
    }
}

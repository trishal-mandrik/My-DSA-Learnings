package Array;

public class BinaryArraySorting {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Function to sort the binary array.
    static void binSort(int[] A, int N) {
        // add your code here
        int j = 0, i = j - 1;
        while (j < N) {
            if (A[j] != 1) {
                swap(A, ++i, j);
            }
            j++;
        }
    }
}

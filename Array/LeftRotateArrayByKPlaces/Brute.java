package Array.LeftRotateArrayByKPlaces;

public class Brute {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is greater than n

        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // shift the remaining elements to the left
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        // copy the first k elements to the end of the array
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - (n - k)];
        }
    }
}



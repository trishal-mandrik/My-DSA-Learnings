package Array.MissingNumberInArithmeticProgression;

public class Brute_Recursive {
    int minJumps(int[] arr) {
        int n = arr.length;

        return findMin(arr, 0, 0, n);

    }

    int findMin(int[] arr, int index, int jumps, int n) {
        if (index >= n - 1) return jumps;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= arr[index]; i++) {
            min = Math.min(min, findMin(arr, index + i, jumps + 1, n));
        }
        return min;
    }
}

//TC: O(N ^ N)
//SC: O(N)
package Array.SmallestSubarrayWithSumGreaterThanX;

public class Brute {
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = 0;

            for (int j = i; j < n; j++) {
                curr += arr[j];

                if (curr > x) {
                    result = Math.min(result, j - i + 1);
                    break;
                }

            }
        }
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }
}

//O(n^2) Time
//O(1) Space
package Array.SmallestSubarrayWithSumGreaterThanX;

public class OptimalUsingSlidingWindow {
    public static int smallestSubWithSum(int x, int[] arr) {
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int n = arr.length;

        while (windowEnd < n) {
            sum += arr[windowEnd];

            if (sum > x) {
                int len = windowEnd - windowStart + 1;
                minLength = Math.min(len, minLength);
            }

            //shrinking
            while (windowStart < windowEnd && sum > x) {
                sum -= arr[windowStart];
                windowStart++;
                if (sum > x) {
                    int len = windowEnd - windowStart + 1;
                    minLength = Math.min(len, minLength);
                }
            }
            windowEnd++;
        }
        if (minLength == Integer.MAX_VALUE) return 0;
        return minLength;
    }
}

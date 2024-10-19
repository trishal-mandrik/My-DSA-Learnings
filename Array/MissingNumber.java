package Array;

public class MissingNumber {
    public static int missingNumber(int n, int[] arr) {
        // code here
        int total = n * (n + 1) / 2;

        for (int i : arr) {
            total -= i;
        }
        return total;
    }
}

/*
Time Complexity: O(n)
Auxiliary Space: O(1)
 */

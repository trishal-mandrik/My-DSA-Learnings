package Array.MaximumProductSubarray;

public class Optimal {
    static int maxProduct(int[] arr) {
        int n = arr.length;

        int prefix = 1, suffix = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n - 1 - i];

            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}

//Time Complexity: O(n), where n is the size of input array.
//Auxiliary Space: O(1)

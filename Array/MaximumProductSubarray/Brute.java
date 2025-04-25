package Array.MaximumProductSubarray;

public class Brute {
    static int maxProduct(int[] arr) {
        int n = arr.length;

        int result = arr[0];

        for (int i = 0; i < n; i++) {
            int mul = 1;

            for (int j = i; j < n; j++) {
                mul *= arr[j];

                result = Math.max(mul, result);
            }
        }
        return result;
    }
}

//Time Complexity: O(n^2), where n is the size of array.
//Auxiliary Space: O(1)

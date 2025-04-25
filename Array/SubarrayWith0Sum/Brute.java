package Array.SubarrayWith0Sum;

public class Brute {
    public static boolean subArrayExists(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            if (sum == 0) return true;

            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                if (sum == 0) return true;
            }
        }
        return false;
    }
}

//Time Complexity: O(N2)
//Auxiliary Space: O(1)

import java.util.ArrayList;

//Brute Force  TC: O(n), SC: O(1)
public class Solution {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        //    Write your code here.
        int n = arr.size();
        if (n == 1) return arr.get(0);

        for (int i = 0; i < n; i++) {
            // Check for first index:
            if (i == 0) {
                if (!arr.get(i).equals(arr.get(i + 1)))
                    return arr.get(i);
            }
            // Check for last index:
            else if (i == n - 1) {
                if (!arr.get(i).equals(arr.get(i - 1)))
                    return arr.get(i);
            } else {
                if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1)))
                    return arr.get(i);
            }
        }

        // Dummy return statement:
        return -1;
    }
}
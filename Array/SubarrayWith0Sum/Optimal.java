package Array.SubarrayWith0Sum;

import java.util.HashSet;
import java.util.Set;

public class Optimal {
    public static boolean subArrayExists(int[] arr) {
        int sum = 0;

        Set<Integer> hs = new HashSet<>();

        for (int j : arr) {
            sum += j;

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set

            if (j == 0 || sum == 0 || hs.contains(sum))
                return true;

            // Add sum to hash set
            hs.add(sum);
        }
        return false;
    }
}

//Time Complexity: O(N) under the assumption that a good hashing function is used, that allows insertion and retrieval operations in O(1) time.
//Auxiliary Space: O(N) Here extra space is required for hashing


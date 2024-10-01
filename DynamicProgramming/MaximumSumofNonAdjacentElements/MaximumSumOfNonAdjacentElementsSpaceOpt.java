package MaximumSumofNonAdjacentElements;

import java.util.ArrayList;

public class MaximumSumOfNonAdjacentElementsSpaceOpt {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.

        // Initialize variables to keep track of the maximum sums at the current and previous positions.
        int prev = nums.getFirst();
        int prev2 = 0;

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.size(); i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int pick = nums.get(i);

            // If there are at least two elements before the current element, add the value from prev2.
            if (i > 1)
                pick += prev2;

            // The non-pick option is to use the maximum sum from the previous position.
            int nonPick = prev;

            // Calculate the maximum sum for the current position and update prev and prev2.
            int curr_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr_i;
        }
        return prev;
    }
}

//TC: O(N);
//SC: O(1);

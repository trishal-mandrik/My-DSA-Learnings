package Array.ThreeSum;

import java.util.*;

public class ThreeSumBetter {
    public static List<List<Integer>> triplet(int n, int[] arr, int target) {
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                // Calculate the 3rd element
                int third = target - (arr[i] + arr[j]);

                // Find the element in the set:
                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}

// Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
// Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

// Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.

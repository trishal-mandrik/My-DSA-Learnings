package FirstAndLastOccurrencesInArray;

import LowerAndUpperBound.LowerBound;

import java.util.ArrayList;

import static LowerAndUpperBound.LowerBound.lowerBound;
import static LowerAndUpperBound.UpperBound.upperBound;

public class Optimal {
    ArrayList<Integer> find(int[] arr, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int lowerBound = lowerBound(arr, x);
        if (lowerBound == arr.length || arr[lowerBound] != x) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        ans.add(lowerBound);
        ans.add(upperBound(arr, x) - 1);
        return ans;
    }
}

// TODO: There is one more approach using single binary search, see striver's video

// TC: O(2 * log N)
// SC: O(1)

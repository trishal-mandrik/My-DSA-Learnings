package Array.TwoSum;
import java.util.*;

// **********************

public class TwoSumBetter {
    public static String read(int n, int []arr, int target){
        // Write your code here.
        Map<Integer, Integer> mpp = new TreeMap<>();
        
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int moreNeeded = target - num;

            if(mpp.containsKey(moreNeeded)) {
                return "YES";
            }

            mpp.put(arr[i], i);
        }
        return "NO";
    }
}

// TC: O(NlogN) SC: O(N)
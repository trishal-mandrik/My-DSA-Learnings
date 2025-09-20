package SlidingWindow.CountDistinctElementsInEveryWindowGfg;
import java.util.*;

public class Optimal {
    ArrayList<Integer> countDistinct(int[] arr, int k) {
        // code here
        int l = 0, r = 0, n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        while(r < n) {
            mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);

            if(r - l + 1 == k) {
                ans.add(mpp.size());
                mpp.put(arr[l], mpp.get(arr[l]) - 1);
                if(mpp.get(arr[l]) == 0) mpp.remove(arr[l]);
                l++;
            }
            r++;
        }
        return ans;
    }
}

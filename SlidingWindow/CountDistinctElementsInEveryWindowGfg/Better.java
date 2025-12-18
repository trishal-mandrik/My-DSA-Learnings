package SlidingWindow.CountDistinctElementsInEveryWindowGfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Better {
    ArrayList<Integer> countDistinct(int[] arr, int k) {
        // code here
        int l = 0, r = k, n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < k; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(mpp.size());

        while (r < n) {
            mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);
            mpp.put(arr[l], mpp.get(arr[l]) - 1);

            if (mpp.getOrDefault(arr[l], 0) == 0) mpp.remove(arr[l]);
            ans.add(mpp.size());
            r++;
            l++;
        }
        return ans;
    }
}

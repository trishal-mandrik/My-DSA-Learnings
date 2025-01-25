package SlidingWindow.FruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class Optimal {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0, len;
        int n = fruits.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        while (r < n) {
            mpp.putIfAbsent(fruits[r], 0);
            mpp.put(fruits[r], mpp.get(fruits[r]) + 1);

            if (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);

                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            if (mpp.size() <= 2) {
                len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}

//TC: O(n)
//SC: O(3)
package SlidingWindow.FruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class Better {
    public int totalFruit(int[] fruits) {
        int len, maxLen = 0, l = 0, r = 0;
        int n = fruits.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        while (r < n) {
            mpp.putIfAbsent(fruits[r], 0);
            mpp.replace(fruits[r], mpp.get(fruits[r]) + 1);

            if (mpp.size() <= 2) {
                len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }

            if (mpp.size() > 2) {
                while (mpp.size() > 2) {
                    mpp.put(fruits[l], mpp.get(fruits[l]) - 1);

                    if (mpp.get(fruits[l]) == 0) {
                        mpp.remove(fruits[l]);
                    }
                    l++;
                }
            }
            r++;
        }
        return maxLen;
    }
}

//TC: O(n + n)
//SC: O(3)

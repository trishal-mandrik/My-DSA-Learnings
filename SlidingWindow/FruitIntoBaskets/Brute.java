package SlidingWindow.FruitIntoBaskets;

import java.util.HashSet;
import java.util.Set;

public class Brute {
    public int totalFruit(int[] fruits) {
        int len, maxLen = 0;
        int n = fruits.length;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                st.add(fruits[i]);

                if (st.size() <= 2) {
                    len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                } else {
                    st.clear();
                    break;
                }
            }
        }
        return maxLen;
    }
}

//TC: O(n * n)
//SC: O(3)
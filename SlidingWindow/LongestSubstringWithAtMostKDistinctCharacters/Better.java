package SlidingWindow.LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Better {
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int l = 0, r = 0, maxLen = 0, len;
        int n = str.length();
        Map<Character, Integer> mpp = new HashMap<>();

        while (r < n) {
            mpp.putIfAbsent(str.charAt(r), 0);
            mpp.put(str.charAt(r), mpp.get(str.charAt(r)) + 1);

            if (mpp.size() <= k) {
                len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }

            if (mpp.size() > k) {
                while (mpp.size() > k) {
                    mpp.put(str.charAt(l), mpp.get(str.charAt(l)) - 1);

                    if (mpp.get(str.charAt(l)) == 0) {
                        mpp.remove(str.charAt(l));
                    }
                    l++;
                }
            }
            r++;
        }
        return maxLen;
    }
}

//TC: O(n + n) + log(256)
//SC: O(256)

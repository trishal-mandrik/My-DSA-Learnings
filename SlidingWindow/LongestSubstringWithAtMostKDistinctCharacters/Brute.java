package SlidingWindow.LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Brute {
    public int kDistinctChars(int k, String str) {
        // Write your code here
        int maxLen = 0, len;
        Map<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            mpp.clear();
            for (int j = i; j < str.length(); j++) {
                mpp.putIfAbsent(str.charAt(j), 0);
                mpp.put(str.charAt(j), mpp.get(str.charAt(j)) + 1);

                if (mpp.size() <= k) {
                    len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                }

                if (mpp.size() > k) {
                    break;
                }
            }
        }
        return maxLen;
    }
}

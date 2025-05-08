package SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Brute {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Integer, Integer> hs = new HashMap<>(256);
            for (int j = i; j < s.length(); j++) {
                if (hs.get((int) s.charAt(j)) == 1) break;
                int len = j - i + 1;
                maxLen = Math.max(len, maxLen);
                hs.put((int) s.charAt(j), 1);
            }
        }
        return maxLen;
    }
}

//TC: O(N * N);
//SC: O(256);

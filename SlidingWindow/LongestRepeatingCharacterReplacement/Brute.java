package SlidingWindow.LongestRepeatingCharacterReplacement;

import java.util.HashMap;

public class Brute {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                mpp.putIfAbsent(c, 0);
                mpp.put(c, mpp.get(c) + 1);

                maxFreq = Math.max(maxFreq, mpp.get(s.charAt(j)));
                int changes = (j - i + 1) - maxFreq;

                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    mpp.clear();
                    break;
                }
            }
        }
        return maxLen;
    }
}

//TC: O(N * N)
//SC: O(26)

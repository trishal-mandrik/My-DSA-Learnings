package SlidingWindow.LongestRepeatingCharacterReplacement;

import java.util.HashMap;

public class Optimal {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, len, maxLen = 0, maxFreq = 0;
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();

        while (r < n) {
            char c1 = s.charAt(r);
            mpp.put(c1, mpp.getOrDefault(c1, 0) + 1);

            maxFreq = Math.max(maxFreq, mpp.get(c1));

            if (((r - l + 1) - maxFreq) <= k) {
                len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }

            if (((r - l + 1) - maxFreq) > k) {
                char c2 = s.charAt(l);
                mpp.put(c2, mpp.get(c2) - 1);
                l++;
            }
            r++;
        }
        return maxLen;
    }
}

//TC : O(N)
//SC: O(26)

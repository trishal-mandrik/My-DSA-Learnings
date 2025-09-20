package SlidingWindow.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Better {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int l = 0, r = 0;
        int cnt = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        while (r < s.length()) {
            if (freq.getOrDefault(t.charAt(r), 0) > 0) {
                cnt++;
            }
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) - 1);

            while (cnt == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) + 1);
                if (freq.getOrDefault(s.charAt(l), 0) > 0) {
                    cnt--;
                }
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}

//TC: O(2N) + O(M)
//SC: O(256)

package SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Better {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        HashSet<Character> hs = new HashSet<>();
        while (j < s.length()) {
            if (!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                j++;
                max = Math.max(max, hs.size());
            } else {
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}

//TC: O(N);
//SC: O(256);

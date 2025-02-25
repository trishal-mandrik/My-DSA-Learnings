package SlidingWindow.MinimumWindowSubstring;

import java.util.HashMap;

public class Brute {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                char ch1 = t.charAt(j);
                mpp.put(ch1, mpp.getOrDefault(ch1, 0) + 1);
            }
            for (int j = 0; j < m; j++) {
                char ch2 = t.charAt(j);
                if(mpp.getOrDefault(ch2, 0) > 0)
                    cnt++;
                mpp.put(ch2, mpp.get(ch2) - 1);

                if (cnt == n) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        sIndex = i;
                        break;
                    }
                }
            }
        }
        return s.substring(sIndex, minLen);
    }
}

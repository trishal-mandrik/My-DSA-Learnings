package SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

public class Optimal {
    public int lengthOfLongestSubstring(String s) {
        int[] hashArray = new int[256];
        int n = s.length();
        int l = 0, r = 0, maxLen = 0, len;

        while (r < n) {
            if (hashArray[s.charAt(r)] != -1) {
                if (hashArray[s.charAt(r)] >= l) {
                    l = hashArray[s.charAt(r)] + 1;
                }
            }
            len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hashArray[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}

//TC: O(N);
//SC: O(256);

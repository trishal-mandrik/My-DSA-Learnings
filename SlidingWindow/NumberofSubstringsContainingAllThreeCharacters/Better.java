package SlidingWindow.NumberofSubstringsContainingAllThreeCharacters;

import java.util.HashSet;

public class Better {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(s.charAt(i));

            for (int j = i; j < n; j++) {
                hs.add(s.charAt(j));

                if (hs.size() == 3) {
                    count = count + (n - j);
                    break;
                }
            }
            hs.clear();
        }
        return count;
    }
}

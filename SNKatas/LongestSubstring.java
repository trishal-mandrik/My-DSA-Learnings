package SNKatas;

public class LongestSubstring {
    public int findLongestSubstring() {
        String str = "abcabcbb";
        String ans;
        int maxi = Integer.MIN_VALUE;
        int length = 0;
        for(int i = 0; i < str.length(); i++) {
            ans += str.charAt(i);
            for(int j = 1; j < str.length(); j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    ans += str.charAt(j);
                }
                break;
            }
            length = ans.length();
            maxi = Math.max(maxi, length);
        }
        return maxi;
    }
}

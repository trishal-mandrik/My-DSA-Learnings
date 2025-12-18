package FirstAndLastOccurrencesInArray;

import java.util.ArrayList;

public class Brute {
    ArrayList<Integer> find(int[] arr, int x) {
        // code here
        int first = -1, last = -1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        ans.add(first);
        ans.add(last);
        return ans;
    }
}

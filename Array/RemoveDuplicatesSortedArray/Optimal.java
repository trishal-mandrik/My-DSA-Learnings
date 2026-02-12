package Array.RemoveDuplicatesSortedArray;

import java.util.ArrayList;

public class Optimal {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        int i = 0, j = 1, cnt = 1;
        while(j < arr.length){
            if (arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
                cnt++;
            }
            j++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int k = 0; k < cnt; k++) {
            result.add(arr[k]);
        }
        return result;
    }
}

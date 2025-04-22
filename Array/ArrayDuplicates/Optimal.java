package Array.ArrayDuplicates;

import java.util.ArrayList;
import java.util.List;

public class Optimal {
    public List<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] / n >= 2){
                duplicates.add(i);
            }
        }

        return duplicates;
    }
}

//Time Complexity: O(n), Only two traversals are needed. So the time complexity is O(n)
//Auxiliary Space: O(1).  As no extra space is needed, so the space complexity is constant

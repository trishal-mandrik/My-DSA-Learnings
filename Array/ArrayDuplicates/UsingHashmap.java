package Array.ArrayDuplicates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsingHashmap {
    public List<Integer> findDuplicates(int[] arr) {
        // code here
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int j : arr) {
            freqMap.put(j, freqMap.getOrDefault(j, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}

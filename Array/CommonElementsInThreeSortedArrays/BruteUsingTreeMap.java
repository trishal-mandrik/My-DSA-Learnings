package Array.CommonElementsInThreeSortedArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BruteUsingTreeMap {
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        // Code Here
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int ele: arr1) {
            map.put(ele, 1);
        }
        for (int ele: arr2) {
            if(map.containsKey(ele) && map.get(ele) == 1) {
                map.put(ele, 2);
            }
        }
        for (int ele: arr3) {
            if(map.containsKey(ele) && map.get(ele) == 1) {
                map.put(ele, 3);
            }
        }

        List<Integer> commonElements = new ArrayList<>();

        for (int ele: map.keySet()) {
            if (map.get(ele) == 3) {
                commonElements.add(ele);
            }
        }
        return commonElements;
    }
}

//Time complexity: O((n1 + n2 + n3)*log n1), where inserting arr1[] takes O(n1 * log(n1)), and lookups for arr2[] and arr3[] take O(n2 * log(n1) + n3 * log(n1))
//Auxiliary Space: O(n1)

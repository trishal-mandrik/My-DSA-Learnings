package Array.CommonElementsInThreeSortedArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OptimalUsing3Pointers {
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> common = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            if (Objects.equals(arr1.get(i), arr2.get(j)) && Objects.equals(arr2.get(j), arr3.get(k))){
                common.add(arr1.get(i));
                i++;
                j++;
                k++;

                while (i < arr1.size() && Objects.equals(arr1.get(i), arr1.get(i - 1))) i++;
                while (j < arr2.size() && Objects.equals(arr2.get(j), arr2.get(j - 1))) j++;
                while (k < arr3.size() && Objects.equals(arr3.get(k), arr3.get(k - 1))) k++;

            } else if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else if (arr2.get(j) < arr3.get(k)) {
                j++;
            } else {
                k++;
            }
        }
        return common;
    }
}

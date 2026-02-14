package Array.UnionOfSortedArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Brute {
    // use sets
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        Set<Integer> union = new HashSet<>();

        for (int j : a) { // TC: O(N) where N is the number of elements in the array
            union.add(j);
        }

        for (int j : b) { // TC: O(M) where M is the number of elements in the array
            union.add(j);
        }

        ArrayList<Integer> sortedUnion = new ArrayList<>(union);
        Collections.sort(sortedUnion); // TC: O(U log U) where U is the number of unique elements in the union
        return sortedUnion;
    }
}


// TC: O(N + M + U log U) where N and M are the number of elements in the input arrays and U is the number of unique elements in the union
// SC: O(U) where U is the number of unique elements in the union
package Array.UnionOfSortedArrays;

import java.util.ArrayList;

public class Optimal {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (union.isEmpty() || union.getLast() != a[i]) {
                    union.add(a[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (union.isEmpty() || union.getLast() != a[i]) {
                union.add(a[i]);
            }
            i++;
        }

        while (j < m) {
            if (union.isEmpty() || union.getLast() != b[j]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }
}

// TC: O(N + M) where N and M are the number of elements in the input arrays
// SC: O(N + M) where U is the number of unique elements in the union
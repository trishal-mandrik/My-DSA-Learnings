package Array.IntersectionOfSortedArrays;

import java.util.ArrayList;

public class Optimal {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (a[i] == b[j]) {
                // if asked for distinct elements then use below condition instead
                // if (a[i] == b[j] && (intersection.isEmpty() || a[i] != intersection.getLast()))
                intersection.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection;
    }
}

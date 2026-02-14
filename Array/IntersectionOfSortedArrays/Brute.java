package Array.IntersectionOfSortedArrays;

import java.util.ArrayList;

public class Brute {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        ArrayList<Integer> intersection = new ArrayList<>();
        boolean[] visited = new boolean[n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (a[i] == b[j] && !visited[j]) {
//                    intersection.add(a[i]);
                    visited[j] = true;
                    break;
                }
                if (b[j] > a[i]) {
                    break;
                }
            }
        }
        return intersection;
    }
}

// TC: O(n1 * n2) where N and M are the number of elements in the input arrays
// SC: O(n2) where N is the number of elements in the intersection (in the worst case, all elements of the smaller array are in the intersection)
package Array.MedianOfTwoSortedArraysOfSameSize;

public class Better_UsingMerge {
    public double medianOf2(int[] a, int[] b) {
        // Your Code Here
        int n = a.length;
        int i = 0, j = 0;

        int m1 = -1, m2 = -1;

        for (int count = 0; count <= n; count++) {
            m2 = m1;

            if (i < n && j < n) {
                if (a[i] > b[j])
                    m1 = b[j++];
                else
                    m1 = a[i++];

            }
            // If only a has remaining elements
            else if (i < n)
                m1 = a[i++];
                // If only b has remaining elements
            else
                m1 = b[j++];
        }
        return (m1 + m2) / 2.0;
    }
}

//Time Complexity: O(n), where n is the size of array a[] and b[].
//Auxiliary Space: O(1)
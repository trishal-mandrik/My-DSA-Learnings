package Array.MedianOfTwoSortedArraysOfDifferentSizes;

public class Brute {
    public double medianOf2(int[] a, int[] b) {
        // Your Code Here
        int i = 0, j = 0;
        int length1 = a.length;
        int length2 = b.length;
        int[] merge = new int[length1 + length2];
        int k = 0;

        while (i < length1 && j < length2) {
            if (a[i] <= b[j]) {
                merge[k++] = a[i++];
            } else {
                merge[k++] = b[j++];
            }
        }

        while (i < length1) merge[k++] = a[i++];
        while (j < length2) merge[k++] = a[j++];

        if (merge.length % 2 == 0) {
            int ind1 = (merge.length / 2);
            int ind2 = (merge.length / 2 + 1);
            return (merge[ind1] + merge[ind2] ) / 2.0;
        } else {
            int middleInd = merge.length / 2;
            return merge[middleInd];
        }
    }
}

package Array.MedianOfTwoSortedArraysOfDifferentSizes;

public class OptimalUsingBinarySearch {
    static double medianOf2(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        // If a[] has more elements, then call medianOf2 with reversed parameters
        if (n1 > n2)
            return medianOf2(b, a);

        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (n1 + n2 + 1) / 2 - mid1;

            // Find elements to the left and right of partition in a[]
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];

            // Find elements to the left and right of partition in b[]
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];

            // If it is a valid partition
            if(l1 <= r2 && l2 <= r1) {
                // If the total elements are even, then median is
                // the average of two middle elements

                if ((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

                    // If the total elements are odd, then median is
                    // the middle element
                else
                    return Math.max(l1, l2);
            }

            // Check if we need to take fewer elements from a[]
            if (l1 > r2)
                high = mid1 - 1;

            // Check if we need to take more elements from a[]
            else
                low = mid1 + 1;
        }
        return 0;
    }
}

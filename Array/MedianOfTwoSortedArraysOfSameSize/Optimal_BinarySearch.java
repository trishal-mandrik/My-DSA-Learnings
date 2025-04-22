package Array.MedianOfTwoSortedArraysOfSameSize;

public class Optimal_BinarySearch {
    public double medianOf2(int[] a, int[] b) {
        int n = a.length;

        // We can take [0...n] number of elements from a[]
        int low = 0, high = n;

        while (low <= high) {
            // Take mid1 elements from a
            int mid1 = low + (high - low) / 2;

            // Take mid2 elements from b
            int mid2 = n - mid1;

            // Find elements to the left and right of partition in a
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            // Find elements to the left and right of partition in b
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == n ? Integer.MAX_VALUE : b[mid2]);

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1)
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

            // If we need to take fewer elements from a
            if (l1 > r2)
                high = mid1 - 1;

                // If we need to take more elements from a
            else
                low = mid1 + 1;
        }

        return 0;
    }
}

//Time Complexity: O(log n), where n is the size of input array.
//Auxiliary Space: O(1)

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] arr, int target) {
        // code here
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
            } else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}

//Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.
//
//Space Complexity: O(1), no extra space used
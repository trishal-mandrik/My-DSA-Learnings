public class SearchInsertPositionOfKInASortedArray {
    public int searchInsertK(int[] arr, int k) {
        // code here
        int left = 0, right = arr.length - 1;
        int ans = arr.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= k) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

// TC: O(log N)
// SC: O(1)

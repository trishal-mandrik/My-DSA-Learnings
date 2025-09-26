public class RotationCountInARotatedSortedArray {
    public int findKRotation(int[] arr) {
        // Code here
        int low = 0, high = arr.length - 1, index = -1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            if(arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                }
                break;
            }

            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return index;
    }
}

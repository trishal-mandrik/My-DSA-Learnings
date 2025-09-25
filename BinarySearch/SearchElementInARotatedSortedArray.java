public class SearchElementInARotatedSortedArray {
    int search(int[] arr, int target) {
        // code here
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

// TC: O(log N)
// SC: O(1)

package SingleElementInSortedArray;

public class Brute {
    int single(int[] arr) {
        // code here
        int ind = 0;
        int n = arr.length;
        while (ind < n) {
            if (ind + 1 < n) {
                if (arr[ind] == arr[ind + 1]) {
                    ind += 2;
                } else {
                    return arr[ind];
                }
            } else {
                return arr[ind];
            }
        }
        return -1;
    }
}

// TC: O(N)
// SC: O(1)

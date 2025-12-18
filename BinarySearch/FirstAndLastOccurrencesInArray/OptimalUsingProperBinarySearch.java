package FirstAndLastOccurrencesInArray;

import java.util.ArrayList;

public class OptimalUsingProperBinarySearch {
    ArrayList<Integer> find(int[] arr, int x) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int first = firstOccurrence(arr, x);
        if (first == -1) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int last = lastOccurrence(arr, x);
        ans.add(first);
        ans.add(last);
        return ans;
    }

    int firstOccurrence(int[] arr, int x) {
        int left = 0, right = arr.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    int lastOccurrence(int[] arr, int x) {
        int left = 0, right = arr.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

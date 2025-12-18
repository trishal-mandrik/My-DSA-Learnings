package BookAllocation;

import java.util.Arrays;

public class Brute {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;

        int minPages = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int maxPages = Arrays.stream(arr).sum();

        for (int pages = minPages; pages <= maxPages; pages++) {
            if (countStudents(arr, pages) == k) {
                return pages;
            }
        }
        return minPages;
    }

    int countStudents(int[] arr, int pages) {
        int studentCount = 1;
        int pageSum = 0;

        for (int j : arr) {
            if (pageSum + j <= pages) {
                pageSum += j;
            } else {
                studentCount++;
                pageSum = j;
            }
        }
        return studentCount;
    }
}

//Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
//        Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible numbers of pages. Inside the loop, we are calling the countStudents() function for each number. Now, inside the countStudents() function, we are using a loop that runs for N times.
//
//Space Complexity:  O(1) as we are not using any extra space to solve this problem.
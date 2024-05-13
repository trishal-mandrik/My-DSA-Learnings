import java.util.ArrayList;

public class BookAllocation {
    static boolean isPossibleSolution(ArrayList<Integer> arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++) {
            if (pageSum + arr.get(i) <= mid) {
                pageSum += arr.get(i);
            } else {
                studentCount++;
                if (studentCount > m || arr.get(i) > mid) {
                    return false;
                }
                pageSum = arr.get(i);
            }
        }
        return true;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        int s = 0;
        int ans = -1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }

        int e = sum;
        int mid;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (isPossibleSolution(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
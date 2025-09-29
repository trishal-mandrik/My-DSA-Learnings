package FindPeakElement;

public class Brute {
    public int peakElement(int[] arr) {
        // code here
        int n = arr.length; int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if((i == 0 || arr[i-1] < arr[i]) && (i == n-1 || arr[i+1] < arr[i])){
                ans = i;
            }
        }
        return ans;
    }
}

// TC: O(N)
// SC: O(1)

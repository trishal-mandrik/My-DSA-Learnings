package SubsetSumEqualToK;

public class Recursive {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        return solve(n - 1, k, arr);
    }

    private static boolean solve(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return (arr[0] == target);

        boolean notTake = solve(index - 1, target, arr);
        boolean take = false;

        if (target >= arr[index])
            take = solve(index - 1, target - arr[index], arr);

        return take || notTake;
    }
}

// TC: O(2 ^ N)
// SC: O(N)

package GridUniquePaths;

public class GridUniquePathsRecursive {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        return getPathsCount(m - 1, n - 1);
    }

    static int getPathsCount(int i, int j) {
        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;
        int up = getPathsCount(i - 1, j);
        int left = getPathsCount(i, j - 1);

        return up + left;
    }
}

/*
 TC: O(2 ^ (m * n))
 SC: O(path length) -> (m-1) + (n-1)
*/

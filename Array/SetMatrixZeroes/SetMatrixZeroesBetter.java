package Array.SetMatrixZeroes;

public class SetMatrixZeroesBetter {
    public void setMatrixZeroes(int[][] arr) {
        int row[] = new int[arr.length];
        int col[] = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ((row[i] == 0) || col[j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}

// TC: O(2 * m * n)
// SC: O(m + n)

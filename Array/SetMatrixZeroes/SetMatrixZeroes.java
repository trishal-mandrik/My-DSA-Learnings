package Array.SetMatrixZeroes;

// Brute Force
public class SetMatrixZeroes {
    public void setMatrixZeroes(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    markRow(arr, i);
                    markCol(arr, j);
                }
            }
        }
        convertToZero(arr);
    }

    void markRow(int[][] arr, int i) {
        for (int j = 0; j < arr[0].length; j++) {
            if(arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    void markCol(int[][] arr, int j) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    void convertToZero(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}

// TC: (m * n) * (m + n) + (m * n) ~ n^3
// SC: O(1)

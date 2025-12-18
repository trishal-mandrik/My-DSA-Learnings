package UniquePathsII;

import java.util.ArrayList;

public class Recursive {

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        //    matrix given is N * M
        return getPathsCount(n - 1, m - 1, mat);
    }

    static int getPathsCount(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if (i >= 0 && j >= 0 && mat.get(i).get(j) == -1) {
            return 0;
        }
        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;
        int up = getPathsCount(i - 1, j, mat);
        int left = getPathsCount(i, j - 1, mat);

        return up + left;
    }
}

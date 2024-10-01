package NinjasTraining;

import java.util.Arrays;

public class NinjasTrainingMemoization {
    static int f(int day, int last, int[][] points, int[][] dp){
        if(day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return dp[day][last] = maxi;
        }

        if (dp[day][last] != -1) return dp[day][last];
        int maxi = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }
    public static int ninjaTraining(int n, int[][] points) {

        // Write your code here..
        int[][] dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(n-1, 3, points, dp);
    }
}

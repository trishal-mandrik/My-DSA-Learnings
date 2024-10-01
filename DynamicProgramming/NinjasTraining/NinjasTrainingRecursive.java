package NinjasTraining;

public class NinjasTrainingRecursive {
    static int f(int day, int last, int[][] points){
        if(day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        int maxi = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }
    public static int ninjaTraining(int n, int[][] points) {

        // Write your code here..
        return f(n-1, 3, points);
    }
}

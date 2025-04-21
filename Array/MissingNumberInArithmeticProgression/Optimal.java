package Array.MissingNumberInArithmeticProgression;

public class Optimal {
    static int minJumps(int[] arr) {
        int n = arr.length;

        int maxReach = 0, currReach = 0, jump = 0;

        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);

            if (maxReach >= n-1) return jump + 1;

            if (i == currReach) {
                if (i == maxReach) return -1;
                else {
                    currReach = maxReach;
                    jump++;
                }
            }
        }
        return -1;
    }
}

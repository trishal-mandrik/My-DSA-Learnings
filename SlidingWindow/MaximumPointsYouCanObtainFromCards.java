package SlidingWindow;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, maxSum;

        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }
        maxSum = lsum;
        int rIndex = cardPoints.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[rIndex];
            rIndex -= 1;

            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }
}

//TC: O(2K)
//SC: O(1)

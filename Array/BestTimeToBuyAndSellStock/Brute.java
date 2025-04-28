package Array.BestTimeToBuyAndSellStock;

public class Brute {
    public int maximumProfit(int[] prices) {
        // Code here
        int profit = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            for (int j = 0; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }

        return profit;
    }
}

// O(n^2) Time
// O(1) Space
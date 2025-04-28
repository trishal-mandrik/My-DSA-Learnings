package Array.BestTimeToBuyAndSellStock;

public class Optimal {
    public int maximumProfit(int[] prices) {
        // Code here
        int minPrice = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);

            profit = Math.max(profit, prices[i] - minPrice);
        }

        return profit;
    }
}

//Time Complexity: O(n), as we are traversing the prices[] array only once.
//Auxiliary Space: O(1)

// 122. Best Time to Buy and Sell Stock II - 06.04.2025

class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        // int buyPrice = prices[0];
        // int sellPrice = prices[0];
        // boolean own = false;

        // for(int i = 1; i < prices.length; i++) {
        //     if(!own) {  // Looking to buy
        //         if(prices[i] <= buyPrice) buyPrice = prices[i];
        //         else {
        //             sellPrice = prices[i];
        //             own = true;
        //         }
        //     } else {    // Looking to sell
        //         if(prices[i] >= sellPrice) sellPrice = prices[i];
        //         else {
        //             profit += sellPrice - buyPrice;
        //             buyPrice = prices[i];
        //             sellPrice = prices[i];
        //             own = false;
        //         }
        //     }
        // }

        // if(own) profit += sellPrice - buyPrice;

        for(int i = 1; i < prices.length; i++) {
            // Running sum of day-to-day increases
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
package leetcode;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different
// day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
// return 0.

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

class StockSellTiming {

    public static void main(String[] args) {
        StockSellTiming stockSellTiming = new StockSellTiming();
        System.out.println(stockSellTiming.maxProfit(new int[] { 1, 2 }) == 1);
        System.out.println(stockSellTiming.maxProfit(new int[] { 7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(stockSellTiming.maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0);
    }

    public int maxProfit(int[] prices) {
        // 각 일마다 가능한 profit을 계산
        // 자신과 자신 뒤에 있는 원소를 비교
        int len = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            }
        }
        // profit이 모두 음수이면 0을 반환
    private int getMaxProfit(int i, int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int j = i + 1; j < len; j++) {
            int profit = prices[j] - prices[i];
            if (profit > max) { // 팔 때 가격이 더 높다면
                max = profit;
            }
        }

        return Math.max(max, 0);
    }
}

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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class StockSellTiming {

    public static void main(String[] args) {
        StockSellTiming stockSellTiming = new StockSellTiming();
        System.out.println(stockSellTiming.maxProfit(new int[] { 1, 2 }) == 1);
        System.out.println(stockSellTiming.maxProfit(new int[] { 7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(stockSellTiming.maxProfit(new int[] { 7, 6, 4, 3, 1 }) == 0);
        System.out.println(stockSellTiming.maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2 }));
        System.out.println(stockSellTiming.maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2, 0, 0, 0, 0, 0 }));
        // 2중 for문을 쓰지 않아도 될까?
        // 구입 가격은 최소, 판매 가격은 최대가 되어야 한다.
        // 2중 for문을 쓰면 가능한 모든 케이스를 계산한다.
        // 구입 가격이 최소가 아니더라도 판매 가격과의 차이로 보면 답인 경우가 있을까?
        // 다음 케이스에서 최소 구입 가격은 0이다. 하지만 이익이 가장 크게 남는 경우의 구입 가격은 0이 아닌 1이다.
        System.out.println(stockSellTiming.maxProfit(new int[] { 1, 8, 0, 3 }));
        // 판매일은 구입일보다 적어도 1일 뒤에 있다.
    }

    // i마다 최대값을 계산한 후에는 i번째 값은 필요 없어진다. ArrayList로 구현하면 맨 앞 값 삭제에 O(N) 단계가 필요하므로
    // 다른 방법을 쓰는 것이 좋을 것 같다.
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int leastBuyPrice = Integer.MAX_VALUE;
        int priceIfSellToday = 0;
        int currentMaxProfit = 0;

        for (int i = 0; i < len; i++) {
            if (prices[i] < leastBuyPrice) {
                leastBuyPrice = prices[i];
            }
            priceIfSellToday = prices[i] - leastBuyPrice;
            if (priceIfSellToday > currentMaxProfit) {
                currentMaxProfit = priceIfSellToday;
            }
        }
        return currentMaxProfit;
    }
}

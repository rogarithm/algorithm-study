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
        System.out.println(stockSellTiming.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
        System.out.println(stockSellTiming.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2, 0, 0, 0, 0, 0}));
    }

    // i마다 최대값을 계산한 후에는 i번째 값은 필요 없어진다. ArrayList로 구현하면 맨 앞 값 삭제에 O(N) 단계가 필요하므로
    // 다른 방법을 쓰는 것이 좋을 것 같다.
    public int maxProfit(int[] prices) {
        // 각 일마다 가능한 profit을 계산
        // 자신과 자신 뒤에 있는 원소를 비교
        int len = prices.length;
        int max = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            deque.add(prices[i]);
        }

        int lenInArrayList = deque.size();
        for (int i = 0; i < lenInArrayList; i++) {
            int ithHighProfit = highProfitFor(i, deque);
            if (ithHighProfit > 0 && ithHighProfit > max) {
                max = ithHighProfit;
            }
        }

        // profit이 모두 음수이면 0을 반환
        return Math.max(max, 0);
    }

    private int highProfitFor(int i, Deque<Integer> prices) {
        int max = Integer.MIN_VALUE;
        Integer buyPrice = prices.pop();
        for (Iterator itr = prices.iterator(); itr.hasNext();) {
            Integer nextSellPrice = (Integer) itr.next();
            int profit = nextSellPrice - buyPrice;
            if (profit > 0 && profit > max) {
                max = profit;
                System.out.println("change max profit: " + max);
            }
        }

        return Math.max(max, 0);
    }
}

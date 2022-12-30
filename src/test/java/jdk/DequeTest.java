package jdk;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        //deque.add(1);
        //deque.add(2);
        //deque.add(3);
        //deque.add(4);
        //deque.add(5);

        int[] test1 = {7, 1, 5, 3, 6, 4};
        int[] test2 = {7, 6, 4, 3, 1};
        int[] test3 = {2, 1, 2, 1, 0, 1, 2};
        int[] test4 = {2, 1, 2, 1, 0, 1, 2, 0, 0, 0, 0, 0};

        for (int i : test1) {
            deque.add(i);
        }

        Integer buyPrice = deque.pop();
        int max = Integer.MIN_VALUE;
        for(Iterator itr = deque.iterator();
                itr.hasNext();)  {
            Integer nextSellPrice = (Integer) itr.next();
            int profit = nextSellPrice - buyPrice;
            if (profit > 0 && profit > max) {
                max = profit;
                System.out.println("change max profit: " + max);
            }
        }
        System.out.println("final max profit is: " + Math.max(max, 0));
    }
}

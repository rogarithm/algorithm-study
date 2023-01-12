package leetcode;

// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement tester = new MajorityElement();
        System.out.println(tester.majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(tester.majorityElement(new int[]{2,2,1,1,1,2,2}) == 2);
    }

    // hashmap에 (숫자, 횟수)를 넣고 횟수가 n/2 이상인 숫자를 검색하는 것은 어떨까?
    // 하지만 값을 기준으로 숫자를 검색하는 것은 간단한 경우에도 어려웠던 것으로 기억한다.

    // 반복하면서 횟수가 n/2 이상인 숫자가 나오면 멈추고 그 숫자를 반환하는 건 어떨까?
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (candidates.get(current) == null) {
                candidates.put(current, 1);
            } else {
                candidates.put(current, candidates.get(current) + 1);
            }
        }

        int threshold = nums.length / 2;
        Set<Entry<Integer, Integer>> entries = candidates.entrySet();
        for (Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > threshold) {
                return entry.getKey();
            }
        }

        return 0;
    }

}

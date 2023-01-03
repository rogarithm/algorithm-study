package leetcode;

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber tester = new SingleNumber();
        System.out.println(tester.singleNumber(new int[]{1}));
        System.out.println(tester.singleNumber(new int[]{1,1,2}));
        System.out.println(tester.singleNumber(new int[]{1,2,3,2,3}));
        System.out.println(tester.singleNumber(new int[]{4,1,2,1,2}));
    }

    public int singleNumber(int[] nums) {
        /* 한 번 나오는 요소를 제외하곤 모두 두 번씩 나오는 점 */
        /* 정답 후보를 기억하고 있으면서 같은 숫자가 한 번 더 나오면 제외하기 */
        /* 입력의 끝에 있는 요소에 다다르기 전에 정답 후보가 하나 이상일 수 있다. 어떤 자료구조에 저장해놓는 게 좋을까? */
        Map<Integer, Integer> cache = new HashMap<>();
        int result = 0;

        for (int num = 0; num < nums.length; num++) {
            int key = nums[num];
            if (cache.get(key) != null) {
                cache.remove(key);
            }
            else {
                result = key; /* 이렇게 하면 첫 번째로 나오는 숫자 모두 result에 할당된다 */
                cache.put(key, 1);
            }
        }
        return result;
    }
}

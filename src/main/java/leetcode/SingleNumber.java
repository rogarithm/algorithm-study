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
    }

    public int singleNumber(int[] nums) {
        /* 한 번 나오는 요소를 제외하곤 모두 두 번씩 나오는 점 */
        /* 정답 후보를 기억하고 있으면서 같은 숫자가 한 번 더 나오면 제외하기 */
        /* 입력의 끝에 있는 요소에 다다르기 전에 정답 후보가 하나 이상일 수 있다. 어떤 자료구조에 저장해놓는 게 좋을까? */
        Map<Integer, Integer> cache = new HashMap<>();
        int result = 0;

        for (int num = 0; num < nums.length; num++) {
            if (cache.get(nums[num]) != null) {
                cache.remove(nums[num]);
            }
            else {
                result = nums[num];
                cache.put(nums[num], 1);
            }
        }
        return result;
    }
}

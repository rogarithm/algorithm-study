package leetcode.easy;

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber tester = new SingleNumber();
        System.out.println(tester.singleNumber(new int[]{1}));
        System.out.println(tester.singleNumber(new int[]{1,1,2}));
        System.out.println(tester.singleNumber(new int[]{1,2,3,2,3}));
        System.out.println(tester.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(tester.singleNumber(new int[]{1,0,1}));
    }

    public int singleNumber(int[] nums) {
        /* 한 번 나오는 요소를 제외하곤 모두 두 번씩 나오는 점 */
        /* 정답 후보를 기억하고 있으면서 같은 숫자가 한 번 더 나오면 제외하기 */
        /* 입력의 끝에 있는 요소에 다다르기 전에 정답 후보가 하나 이상일 수 있다. 어떤 자료구조에 저장해놓는 게 좋을까? */

        /* 어떤 요소가 두 번 나올 때, 연속으로 나온다는 보장이 없으므로 입력을 스캔하는 동안 요소와 요소가 나온 횟수를 hashMap으로 저장했다 */
        /* 계산하는 도중에는 출력값이 될 수 있는 요소가 여러 개 될 수 있으므로 이들을 모아두고 두 번 나온 값은 제거해 마지막으로 남은 요소를
        * 출력으로 내보내기 위해 스택을 이용했다. 하지만 스택 가장 위에 있는 값이 아닌 상황이 생겼다. */

        Set<Integer> cache = new HashSet<Integer>();
        for (int num = 0; num < nums.length; num++) {
            int value = nums[num];
            if (!cache.contains(value)) {
                cache.add(value);
            } else if (cache.contains(value)) {
                cache.remove(value);
            }
        }
        Iterator<Integer> result = cache.iterator();
        if (result.hasNext()) {
            return result.next();
        }

        return 0;
    }
}

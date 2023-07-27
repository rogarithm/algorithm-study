package leetcode.easy;

public class SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     *
     * Example 2:
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     *
     * Example 3:
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     */

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums1 = {1, 3, 5, 6};
        System.out.println(sip.searchInsert(nums1, 3) == 1);
        System.out.println(sip.searchInsert(nums1, 1) == 0);
        System.out.println(sip.searchInsert(nums1, 5) == 2);
        System.out.println(sip.searchInsert(nums1, 6) == 3);
        System.out.println(sip.searchInsert(nums1, 2) == 1);
        System.out.println(sip.searchInsert(nums1, 7) == 4);
        // 예상과 다른 결과 나오는 케이스
        System.out.println(sip.searchInsert(nums1, 0) == 0);

        int[] check = {1, 3};
        System.out.println(sip.searchInsert(check, 0) == 0);
        System.out.println(sip.searchInsert(check, 2) == 1);

        System.out.println(sip.searchInsert(check, 1) == 0);
        System.out.println(sip.searchInsert(check, 3) == 1);
        System.out.println(sip.searchInsert(check, 4) == 2);

        int[] check2 = {1, 3, 5};
        System.out.println(sip.searchInsert(check2, 6) == 3);
    }

    // O(log n) 여야 하므로 트리를 사용하는 게 좋을 것 같다. 혹은 binary search
    // 입력 중에 없는 값인지 알려면 중앙값을 제외하고 적어도 요소 두 개는 확인해야 한다. 하지만 입력이 두 개 이하면 인덱스 에러가 난다.
    // -> 체크한 요소 값보다 1 작은(큰) 값과 target을 비교하는 건 어떨까?
    public int searchInsert(int[] nums, int target) {
        int arrayLength = nums.length;
        if (arrayLength == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        } else if (arrayLength == 2) {
            if (nums[0] >= target) {
                return 0;
            } else if (target <= nums[1]) {
                return 1;
            } else {
                return 2;
            }
        }

        // 주어진 배열을 둘로 나눈다. 일단 배열 갯수가 짝수일 경우
        else if (arrayLength % 2 == 0) {
            // length / 2 - 1 이하와 초과 범위로 나뉜다
            // 앞쪽 맨 뒤 값과 target을 비교하자
            if (nums[arrayLength / 2 - 1] == target) {
                return arrayLength / 2 - 1;
            } else if (nums[arrayLength / 2 - 1] > target) {
                // target은 앞쪽 배열에 있다.
                // 0 <= index < length/2 - 1 범위를 찾아봐야 한다.
                int[] earlier = new int[arrayLength / 2 - 1];
                System.arraycopy(nums, 0, earlier, 0, arrayLength / 2 - 1);
                return searchInsert(earlier, target);
            } else {
                // target은 뒷쪽 배열에 있다.
                // length/2 - 1 <= index < length 범위를 찾아봐야 한다.
                int[] later = new int[arrayLength / 2];
                System.arraycopy(nums, arrayLength / 2, later, 0, arrayLength / 2);
                return searchInsert(later, target)
                    + arrayLength / 2; // 인덱스 값을 맞추려면 잘린 앞쪽 길이를 붙여야 한다.
            }
        }
        //// 배열 갯수가 홀수일 경우
        else {
            // 앞쪽 맨 뒤 값과 target을 비교하자
            if (nums[(arrayLength - 1) / 2] == target) {
                return (arrayLength - 1) / 2;
            } else if (nums[(arrayLength - 1) / 2] > target) {
                // target은 앞쪽 배열에 있다.
                // 0 <= index < length/2 - 1 범위를 찾아봐야 한다.
                int[] earlier = new int[(arrayLength - 1) / 2];
                System.arraycopy(nums, 0, earlier, 0, (arrayLength - 1) / 2);
                return searchInsert(earlier, target);
            } else {
                // target은 뒷쪽 배열에 있다.
                // length/2 - 1 <= index < length 범위를 찾아봐야 한다.
                int[] later = new int[(arrayLength - 1) / 2];
                System.arraycopy(nums, arrayLength - ((arrayLength - 1) / 2), later, 0,
                    (arrayLength - 1) / 2);
                return searchInsert(later, target)
                    + arrayLength - ((arrayLength - 1) / 2); // 인덱스 값을 맞추려면 잘린 앞쪽 길이를 붙여야 한다.
            }
        }
    }
}
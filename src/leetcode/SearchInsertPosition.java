
// Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.
//
// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2
//
// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1
//
// Example 3:
// Input: nums = [1,3,5,6], target = 7
// Output: 4

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums1 = {1, 3, 5, 6};
        //System.out.println(sip.searchInsert(nums1, 5) == 2);
        System.out.println(sip.searchInsert(nums1, 3) == 1);
    }

    // O(log n) 여야 하므로 트리를 사용하는 게 좋을 것 같다. 혹은 binary search
    public int searchInsert(int[] nums, int target) {
        // 주어진 배열을 둘로 나눈다. 일단 배열 갯수가 짝수일 경우
        if (nums.length % 2 == 0) {
            // length / 2 - 1 이하와 초과 범위로 나뉜다
            // 앞쪽 맨 뒤 값과 target을 비교하자
            if (nums[nums.length / 2 - 1] == target) {
                return nums.length / 2 - 1;
            } else if (nums[nums.length / 2 - 1] > target) {
                // target은 앞쪽 배열에 있다.
                // 앞쪽 배열만 검색하려면?
                return 0;
            } else {
                // target은 뒷쪽 배열에 있다.
                // 뒷쪽 배열만 검색하려면?
                return 0;
            }
        }
        // 배열 갯수가 홀수일 경우
        return 0;
    }
}

package leetcode.easy;

// 20220821
class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2]; // 값을 주고 배열을 초기화하려면 어떻게 해야 하지?

        // 모든 경우를 어떻게 다 확인하지?
        for (int j = 0; j < nums.length; j++) { // 배열의 길이는 arr.length
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[j] + nums[k] == target) {
                    result[0] = j;
                    result[1] = k;
                }
            }
        }

        return result;
    }
}
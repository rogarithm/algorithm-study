package leetcode;

import java.util.Arrays;

// leetcode 108. Convert Sorted Array to Binary Search Tree
// 입력으로 주어지는 배열은 오름차순으로 정렬되어 있다
// 배열을 BST로 변환해야 한다
// 배열로부터 root, left, right, left에 연결되는 left, right, right에 연결되는 left, right를 결정해야 한다
public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST tester = new SortedArrayToBST();
        // 값이 하나 있으면 이 값을 root로 하는 TreeNode를 만든다
        int[] testCase1 = {1};
        TreeNode testResult1 = tester.sortedArrayToBST(testCase1);
        System.out.println(
                testResult1.val == 1
        );

        // 값이 둘 있으면 둘 중 작은 값을 root로, 큰 값을 right로 하는 TreeNode를 만들거나,
        // 둘 중 큰 값을 root로, 작은 값을 left로 하는 TreeNode를 만든다
        int[] testCase2 = {1, 2};
        TreeNode testResult2 = tester.sortedArrayToBST(testCase2);
        System.out.println(
                testResult2.val == 1 && testResult2.right.val == 2
                || testResult2.val == 2 && testResult2.left.val == 1
        );

        // 값이 셋 있으면 셋 중 중간 값을 root로, 작은 값을 left로, 큰 값을 right로 하는
        // TreeNode를 만든다
        int[] testCase3 = {1, 2, 3};
        TreeNode testResult3 = tester.sortedArrayToBST(testCase3);
        System.out.println(
                testResult3.val == 2 && testResult3.left.val == 1
                && testResult3.right.val == 3
        );

        // 배열의 요소 갯수가 홀수 개라면, 중간 위치의 값을 root로 하고 root 왼쪽 요소들이 left TreeNode, root 오른쪽
        // 요소들이 right TreeNode가 되는 TreeNode를 만든다
        int[] testCase4 = {1, 2, 3, 4, 5};
        TreeNode testResult4 = tester.sortedArrayToBST(testCase4);
        System.out.println(
                testResult4.val == 3 && testResult4.left.val == 2
                && testResult4.left.left.val == 1 && testResult4.right.val == 5
                && testResult4.right.left.val == 4
        );

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 2) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), null);
        }
        if (nums.length == 3) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));
        }
        if (nums.length > 3) {
            int mid = nums.length / 2;
            return new TreeNode(
                    nums[mid],
                    sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid - 1)),
                    sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length - 1))
            );
        }
        return null;
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

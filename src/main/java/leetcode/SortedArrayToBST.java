package leetcode;

// leetcode 108. Convert Sorted Array to Binary Search Tree
// 입력으로 주어지는 배열은 오름차순으로 정렬되어 있다
// 배열을 BST로 변환해야 한다
// 배열로부터 root, left, right, left에 연결되는 left, right, right에 연결되는 left, right를 결정해야 한다
public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST tester = new SortedArrayToBST();
        // 값이 하나 있으면 이 값을 root로 하는 TreeNode를 만든다
        System.out.println(
                tester.sortedArrayToBST(new int[]{1}).val == 1
        );

        // 값이 둘 있으면 둘 중 작은 값을 root로, 큰 값을 right로 하는 TreeNode를 만들거나,
        // 둘 중 큰 값을 root로, 작은 값을 left로 하는 TreeNode를 만든다

        // 값이 셋 있으면 셋 중 중간 값을 root로, 작은 값을 left로, 큰 값을 right로 하는
        // TreeNode를 만든다

        // 배열의 요소 갯수가 홀수 개라면, 중간 위치의 값을 root로 하고 root 왼쪽 요소들이 left TreeNode, root 오른쪽
        // 요소들이 right TreeNode가 되는 TreeNode를 만든다
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return new TreeNode();
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

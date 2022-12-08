package leetcode;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
       
        System.out.println(st.isSymmetric(
                new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
        System.out.println(st.isSymmetric(
                new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(4), new TreeNode(3)))
        ));

        // 테스트 실패 케이스! : [1,2,2,2,null,2]
        // null을 무시하고 모으기 때문에
        System.out.println(st.isSymmetric(
                new TreeNode(1, new TreeNode(2, new TreeNode(2), null),
                        new TreeNode(2, new TreeNode(2), null))
        ));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return checkSymmetry(root.left, root.right);
    }

    private boolean checkSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            // 자식이 null이더라도 대칭이면 괜찮다
            // 자식이 대칭인지 확인
            return checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
        }

        return false;
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

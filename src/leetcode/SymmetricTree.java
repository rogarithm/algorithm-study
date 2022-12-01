public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2))));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left.val == root.right.val) {
            return true;
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

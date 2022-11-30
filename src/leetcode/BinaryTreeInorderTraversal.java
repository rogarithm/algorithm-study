import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        System.out.println(btit.inorderTraversal(null));
        System.out.println(btit.inorderTraversal(new TreeNode(1)));
        System.out.println(btit.inorderTraversal(
                new TreeNode(1,
                        new TreeNode(),
                        new TreeNode())));
        System.out.println(btit.inorderTraversal(
                new TreeNode(1,
                        new TreeNode(),
                        new TreeNode(2, null, new TreeNode(3))
                )));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            List<Integer> lefts = inorderTraversal(root.left);
            //System.out.println("lefts: " + lefts);
            for (Integer left : lefts) {
                //System.out.println("left: " + left);
                if (left != null) {
                    result.add(left);
                }
            }
        }
        result.add(root.val);
        if (root.right != null) {
            List<Integer> rights = inorderTraversal(root.right);
            for (Integer right : rights) {
                //System.out.println("right: " + right);
                result.add(right);
            }
        }
        return result;
    }

    public static class TreeNode {

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

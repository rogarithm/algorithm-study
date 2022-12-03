import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2))));
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
        // left treeNode의 inorder traversal 결과를 뒤집은 게 right treeNode의 inorder traversal 결과와 같다면
        // 둘은 symmetric하다고 할 수 있을 것 같다.

        // 이렇게 구현하려면 inorder traversal 연산하는 메서드, 연산 결과를 뒤집을 메서드 두 개가 필요하다.

        if (root.left == null || root.right == null) {
            return false;
        }

        List<Integer> lefts = inorderTraversal(root.left);
        System.out.println("LEFTS: " + lefts);
        List<Integer> rights = inorderTraversal(root.right);
        System.out.println("RIGHTS: " + rights);
        ArrayList<Integer> reversedRights = new ArrayList<>();
        for (int length = rights.size() - 1; length >= 0; length--) {
            reversedRights.add(rights.get(length));
        }
        System.out.println("REVERSED RIGHTS: " + reversedRights);

        if (lefts.equals(reversedRights)) {
            return true;
        }

        return false;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            List<Integer> lefts = inorderTraversal(root.left);
            for (Integer left : lefts) {
                if (left != null) {
                    result.add(left);
                }
            }
        }
        result.add(root.val);
        if (root.right != null) {
            List<Integer> rights = inorderTraversal(root.right);
            for (Integer right : rights) {
                result.add(right);
            }
        }
        return result;
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

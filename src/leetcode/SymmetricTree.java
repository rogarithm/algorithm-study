public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2))));
        System.out.println(st.isSymmetric(
                new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)))) == false);
    }

    public boolean isSymmetric(TreeNode root) {
        // left treeNode의 inorder traversal 결과를 뒤집은 게 right treeNode의 inorder traversal 결과와 같다면
        // 둘은 symmetric하다고 할 수 있을 것 같다.

        // 이렇게 구현하려면 inorder traversal 연산하는 메서드, 연산 결과를 뒤집을 메서드 두 개가 필요하다.

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

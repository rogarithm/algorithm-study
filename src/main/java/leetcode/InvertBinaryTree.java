package leetcode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree tester = new InvertBinaryTree();
        System.out.println(tester.invertTree(null) == null);
    }

    public TreeNode invertTree(TreeNode root) {
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

        // 테스트 결과 확인을 위해 TreeNode의 요소를 출력하는 메서드
        @Override
        public String toString() {
            String result = "";
            result += "ROOT: " + Integer.toString(this.val);
            if (this.left != null) {
                result += "\n" + " LEFT\n" + "  " + this.left.toString() + "\n";
            }
            if (this.right != null) {
                result += " RIGHT\n" + "  " + this.right.toString() + "\n";
            }
            return result;
        }

        private void testToString() {
            TreeNode testPrint1 = new TreeNode(1);
            TreeNode testPrint2 = new TreeNode(2, new TreeNode(1), null);
            TreeNode testPrint3 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
            TreeNode testPrint4 = new TreeNode(3,
                    new TreeNode(2, new TreeNode(1), null),
                    new TreeNode(5, new TreeNode(4), null));
            System.out.println(testPrint1.toString());
            System.out.println(testPrint2.toString());
            System.out.println(testPrint3.toString());
            System.out.println(testPrint4.toString());
        }
    }
}

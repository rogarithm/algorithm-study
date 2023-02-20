package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import leetcode.easy.SymmetricTree;
import leetcode.easy.SymmetricTree.TreeNode;
import org.junit.jupiter.api.Test;

class SymmetricTreeTest {

    @Test
    public void testIsSymmetric() {
        SymmetricTree st = new SymmetricTree();
        assertFalse(st.isSymmetric(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)))
        ));

        assertTrue(st.isSymmetric(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(4), new TreeNode(3)))
        ));

        // 테스트 실패 케이스! : [1,2,2,2,null,2]
        // null을 무시하고 모으기 때문에
        assertFalse(st.isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(2), null),
                new TreeNode(2, new TreeNode(2), null))
        ));
    }

}
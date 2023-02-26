package datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrieTest {

    @Test
    @DisplayName("문자 하나를 trie에 추가할 수 있다")
    public void addOneCharToTrie() {
        Trie trie = new Trie();
        trie.addWord("a");
        Assertions.assertThat(trie.search("a")).isTrue();
    }

    @Test
    @DisplayName("문자 여러개를 trie에 추가할 수 있다")
    public void addMultipleCharsToTrie() {
        Trie trie = new Trie();
        trie.addWord("ab");
        Assertions.assertThat(trie.search("ab")).isTrue();
    }

    private static class Trie {

        TreeNode words;

        public Trie() {
            words = new TreeNode();
        }

        public void addWord(String s) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                this.currentChar = c;
            }
        }

        public boolean search(String s) {
            return true;
        }
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
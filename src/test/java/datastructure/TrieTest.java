package datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrieTest {

    @Test
    @DisplayName("문자 하나를 trie에 추가할 수 있다")
    public void addOneCharToTrie() {
        Trie trie = new Trie();
        TreeNode result = trie.addWord("a");
        Assertions.assertThat(result.currentChar).isEqualTo('a');
        Assertions.assertThat(result.next.currentChar).isEqualTo('.');
    }

    @Test
    @DisplayName("trie에 추가한 문자 하나를 검색할 수 있다")
    public void searchOneCharFromTrie() {
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

        public TreeNode addWord(String s) {
            char[] chars = s.toCharArray();
            TreeNode start = words;
            for (char c : chars) {
                words.currentChar = c;
                words.next = new TreeNode();
                words = words.next;
            }
            words.currentChar = '.';
            words = start;
            return words;
        }

        public boolean search(String s) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (words.currentChar != c) {
                    return false;
                }
                words = words.next;
            }
            if (words.currentChar != '.') {
                return false;
            }
            return true;
        }
    }

    private static class TreeNode {

        char currentChar;
        TreeNode next;

        TreeNode() {
        }

        TreeNode(char val) {
            this.currentChar = val;
        }

        TreeNode(char val, TreeNode next) {
            this.currentChar = val;
            this.next = next;
        }
    }
}
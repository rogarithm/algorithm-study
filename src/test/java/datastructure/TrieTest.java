package datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrieTest {

    @Test
    @DisplayName("문자 하나를 trie에 추가할 수 있다")
    public void addOneCharToTrie() {
        Trie trie = new Trie();
        Node result = trie.addWord("a");
        Assertions.assertThat(result.currentChar).isEqualTo('a');
        Assertions.assertThat(result.next.currentChar).isEqualTo('.');
    }

    @Test
    @DisplayName("문자 여러개로 이뤄진 단어를 trie에 추가할 수 있다")
    public void addMultipleCharToTrie() {
        Trie trie = new Trie();
        Node result = trie.addWord("bad");
        Assertions.assertThat(result.currentChar).isEqualTo('b');
        Assertions.assertThat(result.next.currentChar).isEqualTo('a');
        Assertions.assertThat(result.next.next.currentChar).isEqualTo('d');
        Assertions.assertThat(result.next.next.next.currentChar).isEqualTo('.');
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

    @Test
    @DisplayName("추가한 문자열 끝을 표시하기 위해 '.' 문자를 추가한다")
    public void addPeriodToSignEndOfString() {
        Trie trie = new Trie();
        trie.addWord("a");
        Assertions.assertThat(trie.words.next.currentChar).isEqualTo('.');
    }

    private static class Trie {

        Node words;

        public Trie() {
            words = new Node();
        }

        public Node addWord(String s) {
            char[] chars = s.toCharArray();
            Node start = words;
            for (char c : chars) {
                words.currentChar = c;
                words.next = new Node();
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

    private static class Node {

        char currentChar;
        Node next;

        Node() {
        }

        Node(char val) {
            this.currentChar = val;
        }

        Node(char val, Node next) {
            this.currentChar = val;
            this.next = next;
        }
    }
}
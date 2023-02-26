package datastructure;

import java.util.ArrayList;
import java.util.List;
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
    @DisplayName("단어 여러개를 trie에 추가할 수 있다")
    public void addMultipleWordsToTrie() {
        Trie trie = new Trie();
        Node ace = trie.addWord("ace");
        Node bad = trie.addWord("bad");
        Assertions.assertThat(ace.currentChar).isEqualTo('a');
        Assertions.assertThat(ace.next.currentChar).isEqualTo('c');
        Assertions.assertThat(ace.next.next.currentChar).isEqualTo('e');
        Assertions.assertThat(ace.next.next.next.currentChar).isEqualTo('.');

        Assertions.assertThat(bad.currentChar).isEqualTo('b');
        Assertions.assertThat(bad.next.currentChar).isEqualTo('a');
        Assertions.assertThat(bad.next.next.currentChar).isEqualTo('d');
        Assertions.assertThat(bad.next.next.next.currentChar).isEqualTo('.');
    }

    @Test
    @DisplayName("trie에 추가한 문자 하나를 검색할 수 있다")
    public void searchOneCharFromTrie() {
        Trie trie = new Trie();
        trie.addWord("a");
        Assertions.assertThat(trie.search("a")).isTrue();
    }

    @Test
    @DisplayName("trie에 추가한 문자 여러개로 이뤄진 단어를 검색할 수 있다")
    public void searchMultipleCharsToTrie() {
        Trie trie = new Trie();
        trie.addWord("bad");
        Assertions.assertThat(trie.search("bad")).isTrue();
    }

    @Test
    @DisplayName("trie에 추가한 단어 여러개를 검색할 수 있다")
    public void searchMultipleWordsFromTrie() {
        Trie trie = new Trie();
        trie.addWord("ace");
        trie.addWord("bad");
        Assertions.assertThat(trie.search("ace")).isTrue();
        Assertions.assertThat(trie.search("bad")).isTrue();
    }

    @Test
    @DisplayName("추가한 문자열 끝을 표시하기 위해 '.' 문자를 추가한다")
    public void addPeriodToSignEndOfString() {
        Trie trie = new Trie();
        trie.addWord("a");
        Assertions.assertThat(trie.words.get(0).next.currentChar).isEqualTo('.');
    }

    private static class Trie {

        List<Node> words;

        public Trie() {
            words = new ArrayList<Node>();
        }

        public Node addWord(String s) {
            char[] chars = s.toCharArray();
            Node word = new Node();
            Node start = word;
            for (char c : chars) {
                word.currentChar = c;
                word.next = new Node();
                word = word.next;
            }
            word.currentChar = '.';
            word = start;
            words.add(word);
            return word;
        }

        public boolean search(String s) {
            char[] chars = s.toCharArray();
            Node word = null;
            for (Node node : words) {
                if (node.currentChar == chars[0]) {
                    word = node;
                    break;
                }
            }

            if (word == null) {
                return false;
            }

            for (char c : chars) {
                if (word.currentChar != c) {
                    return false;
                }
                word = word.next;
            }
            if (word.currentChar != '.') {
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
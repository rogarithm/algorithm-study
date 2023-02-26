package datastructure;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrieTest {

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
    @DisplayName("추가한 문자열 끝을 표시하기 위해 '.' 문자를 쓴다")
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

        public void addWord(String s) {
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
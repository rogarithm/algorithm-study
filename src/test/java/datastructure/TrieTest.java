package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrieTest {

    @Test
    @DisplayName("trie에 추가한 문자 하나를 검색할 수 있다")
    public void searchOneCharFromTrie() {
        Trie trie = new Trie();
        trie.addWord("a");
        //Assertions.assertThat(trie.search("a")).isTrue();
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
    @DisplayName("첫 글자가 공통인 단어 여러개를 trie에 추가하면, 공통인 글자는 한 번만 저장한다")
    public void searchMultipleWordsWithSamePrefixToTrie() {
        Trie trie = new Trie();
        trie.addWord("ace");
        trie.addWord("add");
        Assertions.assertThat(trie.search("ace")).isTrue();
        Assertions.assertThat(trie.search("add")).isTrue();
    }

    @Test
    @DisplayName("추가한 문자열 끝을 표시하기 위해 '.' 문자를 쓴다")
    public void addPeriodToSignEndOfString() {
        Trie trie = new Trie();
        trie.addWord("a");
        trie.words.get('a');
    }

    private static class Trie {

        List<Node> words;

        public Trie() {
            words = new ArrayList<Node>();
        }

        public void addWord(String s) {
            char[] chars = s.toCharArray();

            Node word = null;
            // 주어진 단어 일부가 이미 등록된 단어의 일부라면 주어진 단어에서 이미 등록된 부분을 제외한 나머지를 추가한다
            for (Node node : words) {
                if (node.currentChar == chars[0]) {
                    word = node;
                    break;
                }
            }

            // 아니라면, 주어진 단어를 새로운 단어로 추가한다
            if (word == null) {
                word = new Node();
            }

            Node start = word;
            // 주어진 단어의 한 글자씩 노드에 입력한다
            for (int i = 0; i < chars.length; i++) {
                word.currentChar = chars[i];
                if (word.next.get(chars[i + 1]) != null) {
                    word = word.next.get(chars[i + 1]);
                }
                else
                    word = word.next.put(chars[i + 1], new Node());
            }
            word.currentChar = '.';
            word = start;
            words.add(word);
        }

        public boolean search(String s) {
            char[] chars = s.toCharArray();
            Node word = null;
            // 검색할 단어의 첫 글자와 일치하는 단어가 trie 안에 있는지 확인한다
            for (Node node : words) {
                if (node.currentChar == chars[0]) {
                    word = node;
                    break;
                }
            }

            // 없으면 등록된 단어가 아니다
            if (word == null) {
                return false;
            }

            for (int i = 0; i < chars.length; i++) {
                if (word.currentChar != chars[i]) {
                    return false;
                }
                word = word.next.get(chars[i + 1]);
            }
            if (word.currentChar != '.') {
                return false;
            }
            return true;
        }
    }

    private static class Node {

        char currentChar;
        Map<Character, Node> next;

        Node() {
        }

        Node(char val) {
            this.currentChar = val;
        }

        Node(char val, Node next) {
            this.currentChar = val;
            this.next.put(next.currentChar, next);
        }
    }
}
package leetcode_medium;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary tester = new WordDictionary();
        tester.addWord("bad");
        System.out.println(tester.search("bad") == true);
        System.out.println(tester.search("pad") == false);
        System.out.println(tester.search(".ad") == true);

        tester.addWord("baz");
        System.out.println(tester.search("ba.") == true);

        // 여러 . 문자가 있는 경우, contains 연산으로 처리 가능한가?
    }

    private Map<String, Boolean> dictionary;

    // 사전으로 쓸 자료 구조를 초기화
    public WordDictionary() {
        dictionary = new HashMap<>();
    }

    // Adds word to the data structure, it can be matched later.
    public void addWord(String word) {
        dictionary.put(word, true);
    }

    // 입력 문자열과 완전히 동일하거나 입력의 '.' 문자 이외 모든 문자가 동일한 단어가 사전에 있으면 true를 반환
    public boolean search(String word) {
        // . 문자를 입력했을 때 검색을 효율적으로 하려면 search에서 . 문자를 어떻게 처리할지를 고민해보는 게 좋을 것 같다
        if (word.contains(".") == false) {
            if (dictionary.get(word) != null && dictionary.get(word) == true)
                return true;
        }
        // 만약 word에 . 문자가 포함되어 있다면, . 문자에 가능한 모든 문자를 대입해 검색한 결과 중 true가 반환되는 경우가 있는지를 확인해보면 될 것 같다.
        // . 문자가 여러 번 나올 경우, 계산이 복잡해지지 않게 하려면 어떻게 해야할까? (문제에서 . 문자는 최대 세 번 나온다고 한다)
        else if (word.contains(".")) {
            int dotPosition = word.indexOf(".");
            char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            for (char character : alpha) {
                String candidate =
                        word.substring(0, dotPosition) + character + word.substring(dotPosition + 1,
                                word.length());
                if (dictionary.get(candidate) != null && dictionary.get(candidate) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}

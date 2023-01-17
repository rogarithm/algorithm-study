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
        if (dictionary.get(word) == null)
            return false;
        else if (dictionary.get(word) == true)
            return true;
        return false;
    }
}

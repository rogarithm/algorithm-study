package leetcode_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionaryFast {
    /*
    어떻게 해야 더 빨리 찾을 수 있을까?
    단어를 단어장에 저장할 때 다음에 그 단어를 찾기 용이하도록 단어장의 자료 구조를 정하는 게 좋을 것 같다.
    떠올린 아이디어는 추가할 단어를 이루는 각 문자와 그 문자의 빈도수를 :와 같은 문자로 구분해 저장하는 것이다.
    ex.
     add -> key: add:a1d2, val: ?
     dad -> key: dad:a1d2, val: ?
    아니면 단어장의 키에는 문자 빈도수만 저장하고, 값에는 문자를 저장할 수도 있을 것 같다.
    ex.
     add -> key: a1d2, val: add
     dad -> key: a1d2, val: dad
    그러면 단어를 찾을 때, 먼저 찾으려는 단어를 구성하는 문자의 빈도를 계산하고, 이 빈도 목록으로 단어장에서 찾을 수 있을 것 같다.
    search(add) ... a1d2 ... get(a1d2) ... true

    문제는 . 문자가 들어간 경우이다. . 문자는 어떤 문자든 될 수 있기 때문에, 기존에 계산한 빈도 목록을 . 문자에 들어갈 수 있는
    문자 빈도를 더한 값으로 바꿔서 단어장에서 다시 찾아야 한다.
    search(a.d) ... a1d1?1 ... get(a2d1) ... false    (? = a)
                           ... get(a1b1d1) ... false  (? = b)
                           ... get(a1c1d1) ... false  (? = c)
                           ... get(a1d2) ... true     (? = d)

    이렇게 되면 가능한 빈도 목록을 반복해서 계산해야 하니 기존 구현 방법과 속도가 비슷하지 않을까?

    이렇게 구현하면 같은 문자 빈도수를 갖는 단어가 한 키에 들어 있게 될 것이다.
     */

    public static void main(String[] args) {
        WordDictionaryFast tester = new WordDictionaryFast();
        tester.addWord("bad");
        System.out.println(tester.search("bad") == true);
        System.out.println(tester.search("pad") == false);
        System.out.println(tester.search(".ad") == true);

        tester.addWord("baz");
        System.out.println(tester.search("ba.") == true);

        // . 문자가 하나인 경우와 둘인 경우를 분기로 나눠야할까?
        // . 문자마다 넣을 문자를 aa, ab, ac와 같이 순서대로 어떻게 넣을 수 있을까?
        tester.addWord("abcd");
        System.out.println(tester.search("a..d") == true);
        tester.addWord("efgh");
        System.out.println(tester.search("e.g.") == true);
        System.out.println(tester.search("...d") == true);

        // 두 . 문자가 떨어져있는 경우 concat은 어떻게 해야할까
    }

    // 문자와 빈도수를 저장하는 것은 어떨까?
    private Map<String, Boolean> dictionary;

    public WordDictionaryFast() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word) {
        dictionary.put(word, true);
    }

    // 입력 문자열과 완전히 동일하거나 입력의 '.' 문자 이외 모든 문자가 동일한 단어가 사전에 있으면 true를 반환

    // 만약 word에 . 문자가 포함되어 있다면, . 문자에 가능한 모든 문자를 대입해 검색한 결과 중 true가 반환되는 경우가 있는지를 확인해보면 될 것 같다.
    // . 문자가 여러 번 나올 경우, 계산이 복잡해지지 않게 하려면 어떻게 해야할까? (문제에서 . 문자는 최대 세 번 나온다고 한다)
    public boolean search(String word) {
        List<Integer> dots = makeListOfDotPositions(word);
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // https://stackoverflow.com/a/17575926

        if (!dots.isEmpty() && dots.size() == 1) {
            for (char character : alpha) {
                String candidate =
                        word.substring(0, dots.get(0)) + character + word.substring(dots.get(0) + 1);
                if (dictionary.get(candidate) != null && dictionary.get(candidate) == true) {
                    return true;
                }
            }
        }
        else if (!dots.isEmpty() && dots.size() == 2) {
            String candidate;
            for (char character1 : alpha) {
                candidate =
                        word.substring(0, dots.get(0)) + character1 + word.substring(dots.get(0) + 1);
                for (char character2 : alpha) {
                    candidate =
                            candidate.substring(0, dots.get(1)) + character2 + candidate.substring(dots.get(1) + 1);
                    if (dictionary.get(candidate) != null && dictionary.get(candidate) == true) {
                        return true;
                    }
                }
            }
        }
        else if (!dots.isEmpty() && dots.size() == 3) {
            String candidate;
            for (char character1 : alpha) {
                candidate =
                        word.substring(0, dots.get(0)) + character1 + word.substring(
                                dots.get(0) + 1);
                for (char character2 : alpha) {
                    candidate =
                            candidate.substring(0, dots.get(1)) + character2 + candidate.substring(
                                    dots.get(1) + 1);
                    for (char character3 : alpha) {
                        candidate =
                                candidate.substring(0, dots.get(2)) + character3
                                        + candidate.substring(dots.get(2) + 1);
                        if (dictionary.get(candidate) != null
                                && dictionary.get(candidate) == true) {
                            return true;
                        }
                    }
                }
            }
        }
        else if (dictionary.get(word) != null && dictionary.get(word) == true) {
            return true;
        }
        return false;
    }

    private List<Integer> makeListOfDotPositions(String word) {
        List<Integer> dots = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                dots.add(i);
            }
        }

        return dots;
    }
}

package leetcode.medium;

import java.util.Arrays;

// 1048. LongestStringChain
// https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain tester = new LongestStringChain();
        System.out.println(tester.longestStrChain(new String[]{"a"}) == 1);
        System.out.println(tester.longestStrChain(new String[]{"a", "ab"}) == 2);
        System.out.println(tester.longestStrChain(new String[]{"a", "ab", "abc"}) == 3);
    }

    //주어진 배열을 정렬한 뒤에 시작하는 것이 좋을 것 같다. String[] 타입을 어떻게 정렬하지?
    // 오름차순 vs 내림차순
    //앞의 요소가 뒤의 요소에서 한 글자를 빼서 만들어질 수 있는지 확인
    // 가능한 한 글자씩 빼보는 걸 어떻게 해봐야할까?
    //동일한 길이의 요소가 여러 가지이고 그 중 일부만 다음 길이 요소의 predecessor가 될 수 있는 경우는 어떻게 처리해야할까?
    public int longestStrChain(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return 1;
        }

        String wordToCompare = words[0];
        String currentWord = words[1];
        for (int i = 0; i < currentWord.length(); i++) {
            if (removeOneCharAt(currentWord, i).equals(wordToCompare)) {
                return 1 + longestStrChain(leftWords(words));
            }
        }

        return 1;
    }

    private String[] leftWords(String[] words) {

        return Arrays.stream(words)
                .skip(1)
                .toArray(String[]::new);
    }

    private String removeOneCharAt(String word, int idx) {
        char[] chars = word.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (i == idx) {
                continue;
            }
            result.append(chars[i]);
        }

        return result.toString();
    }

}

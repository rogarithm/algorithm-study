package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// 1048. LongestStringChain
// https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain tester = new LongestStringChain();
        System.out.println(tester.longestStrChain(new String[]{"a"}) == 1);
        System.out.println(tester.longestStrChain(new String[]{"a", "ab"}) == 2);
        System.out.println(tester.longestStrChain(new String[]{"a", "ab", "abc"}) == 3);
        System.out.println(tester.longestStrChain(new String[]{"a", "ab", "acb"}) == 3);
        System.out.println(tester.longestStrChain(new String[]{"cab", "a", "ab"}) == 3);
        System.out.println(tester.longestStrChain(new String[]{"a", "b", "ba"}) == 2);
        System.out.println(tester.longestStrChain(new String[]{"a", "ca", "da", "dca"}) == 3);
        //System.out.println(tester.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}) == 4);

    }

    public int longestStrChain(String[] words) {

        Map<String, Integer> cache = new HashMap<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //오름차순으로 정렬
            }
        });

        int result = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String previous = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, cache.getOrDefault(previous, 0) + 1);
            }
            cache.put(word, best);
            result = Math.max(result, best);
        }
        return result;
    }
}

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

    //이 문제도 Trie 구조로 생각해야 하는 문제인 것 같다
    // 가능한 케이스 중 가장 긴 경우를 찾는 것이므로
    // 문자가 하나 더 추가될 때 그 문자의 위치가 이전 문자 맨 앞/사이 어딘가/맨 끝 어디가 되었든 상관 없는 게 특징이라고 생각된다

    //주어진 배열을 정렬한 뒤에 시작하는 것이 좋을 것 같다. String[] 타입을 어떻게 정렬하지?
    // 오름차순 vs 내림차순
    //앞의 요소가 뒤의 요소에서 한 글자를 빼서 만들어질 수 있는지 확인
    // 가능한 한 글자씩 빼보는 걸 어떻게 해봐야할까?
    //동일한 길이의 요소가 여러 가지이고 그 중 일부만 다음 길이 요소의 predecessor가 될 수 있는 경우는 어떻게 처리해야할까?
    // 동일한 길이의 요소가 앞에 여러 개 있을 경우와 한 개만 있을 경우를 다르게 처리하면 어떨까
    public int longestStrChain(String[] words) {

    }
}

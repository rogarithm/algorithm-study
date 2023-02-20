package leetcode.medium;

// 1048. LongestStringChain
// https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain tester = new LongestStringChain();
        System.out.println(tester.longestStrChain(new String[]{"a", "ab"}) == 2);
    }

    //주어진 배열을 정렬한 뒤에 시작하는 것이 좋을 것 같다. String[] 타입을 어떻게 정렬하지?
    //오름차순 vs 내림차순
    //앞의 요소가 뒤의 요소에서 한 글자를 빼서 만들어질 수 있는지 확인
    //동일한 길이의 요소가 여러 가지이고 그 중 일부만 다음 길이 요소의 predecessor가 될 수 있는 경우는 어떻게 처리해야할까?
    public int longestStrChain(String[] words) {
        return 2;
    }

}

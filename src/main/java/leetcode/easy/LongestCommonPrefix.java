package leetcode.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix tester = new LongestCommonPrefix();
        String[] t1 = {"flower","flow","flight"};
        String r1 = tester.longestCommonPrefix(t1);
        System.out.println(r1);
        String[] t2 = {"dog","racecar","car"};
        String r2 = tester.longestCommonPrefix(t2);
        System.out.println(r2);
    }

    //prefix class?를 만들고, 공통으로 일치하는 부분을 알아내면 될 것 같다
    //첫 단어를 모두 집어넣고, 다음 단어는 공통된 부분까지만 확인하자. 주어진 문자열 모두 공통으로 가지고 있어야 하니까 이래도 상관 없을 것 같다
    class PrefixTree {

        PrefixTree[] nexts = new PrefixTree[26];
    }

    public String longestCommonPrefix(String[] strs) {
        PrefixTree cache = new PrefixTree();
        String base = strs[0];
        PrefixTree start = cache;

        //첫 단어 안 문자를
        for (char c : base.toCharArray()) {
            //Prefix tree에 넣는다
            cache.nexts[c - 'a'] = new PrefixTree();
            cache = cache.nexts[c - 'a'];
        }
        //다른 단어로 연산하기 위해 옮겨진 포인터를 처음으로 되돌린다
        cache = start;

        StringBuilder result = new StringBuilder();
        result.append(base);

        //나머지 단어마다
        for (int i = 1; i < strs.length; i++) {
            StringBuilder currentCommonPrefix = new StringBuilder();
            //한 글자씩 순회하면서
            for (char c : strs[i].toCharArray()) {
                //공통인 글자이면 예상 답에 집어넣고,
                if (cache.nexts[c - 'a'] != null) {
                    cache = cache.nexts[c - 'a'];
                    currentCommonPrefix.append(c);
                }
                //아니면 더 이상 진행할 수 없으니 빠져나간다
                else {
                    break;
                }
            }

            //이 케이스만으로 처리할 수 있다. 만약 중간 어느때라도 한 번만 공통인 부분이 없는 경우가 나오면 그 다음부턴 result의 길이는 0이다
            if (currentCommonPrefix.length() < result.length()) {
                result = currentCommonPrefix;
            }
            //System.out.println("current common prefix: " + currentCommonPrefix);
            //System.out.println("current result: " + result);
            
            cache = start;
        }

        return result.toString();
    }
}

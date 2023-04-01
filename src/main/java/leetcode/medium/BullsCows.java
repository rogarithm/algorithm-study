package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class BullsCows {

    public static void main(String[] args) {
        BullsCows tester = new BullsCows();
        System.out.println(tester.getHint("1807", "7810"));
        System.out.println(tester.getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        //올바른 자리에 있는 정답인 숫자를 bulls, 다른 자리에 있는 정답인 숫자를 cows
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        Map<Character, Integer> secretCache = new HashMap<>();
        Map<Character, Integer> guessCache = new HashMap<>();
        int bullsCount = 0;
        int cowsCount = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bullsCount++;
                continue;
            }
            if (s[i] != g[i]) {
                secretCache.putIfAbsent(s[i], 0);
                guessCache.putIfAbsent(g[i], 0);
                secretCache.put(s[i], secretCache.get(s[i]) + 1);
                guessCache.put(g[i], guessCache.get(g[i]) + 1);
            }
        }

        //맞히지 못한 문자 중 guess에 있는 문자가 있다면 cows를 증가시킨다
        for (Character c : secretCache.keySet()) {
            if (guessCache.get(c) != null) {
                //두 캐시에 저장된 숫자가 같다면 그 숫자만큼 cows를 증가시킨다
                if (secretCache.get(c) == guessCache.get(c))
                    cowsCount += guessCache.get(c);
                //예상치에 저장된 숫자가 더 작다면 예상치에 저장된 숫자만큼 cows를 증가시킨다
                if (secretCache.get(c) > guessCache.get(c))
                    cowsCount += guessCache.get(c);
                //예상치에 저장된 숫자가 더 많다면, 답안쪽 숫자만큼만 cows를 증가시킨다
                if (secretCache.get(c) < guessCache.get(c))
                    cowsCount += secretCache.get(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bullsCount);
        sb.append("A");
        sb.append(cowsCount);
        sb.append("B");
        return sb.toString();
    }
}

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

        for (Character c : secretCache.keySet()) {
            if (guessCache.get(c) != null) {
                if (secretCache.get(c) == guessCache.get(c))
                    cowsCount += guessCache.get(c);
                if (secretCache.get(c) > guessCache.get(c))
                    cowsCount += guessCache.get(c);
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

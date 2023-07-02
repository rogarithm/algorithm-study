package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] count = new int[26];
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<count.length; i++) {
            result.append(count[i]);
            if (i != count.length-1)
                result.append(" ");
        }
        System.out.println(result);
    }
}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] freq = new int[26];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //위 반복문에서 모든 요소를 -1으로 초기화했고, 앞 루프에서 값이 바뀌었다면 값은 0 이상이다.
            //아직 안나온 알파벳이라면 첫번째로 나온 것이므로 위치를 기록한다.
            if (freq[c - 'a'] == -1) {
                freq[c - 'a'] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            result.append(freq[i]);
            if (i != freq.length - 1) {
                result.append(" ");
            }
        }

        System.out.println(result);
    }

}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1373 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        StringBuilder result = new StringBuilder();
        if (num.length() % 3 == 1) {
            result.append(num.charAt(0) - '0');
        }

        if (num.length() % 3 == 2) {
            result.append(((num.charAt(0) - '0') * 2) + (num.charAt(1) - '0'));
        }

        for (int i = num.length() % 3; i < num.length(); i += 3) {
            result.append(((num.charAt(i) - '0') * 4) + ((num.charAt(i + 1) - '0') * 2) + (num.charAt(i + 2) - '0'));
        }

        System.out.println(result);
    }
}
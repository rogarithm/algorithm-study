package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p10820 {

    public static void main(String[] args) throws IOException {
        String input = "a\nb";
        BufferedReader br = new BufferedReader(new StringReader(input));

        String line = br.readLine();
        while (line != null) {
            int small = 0;
            int big = 0;
            int num = 0;
            int space = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c - 'a' >= 0 && c - 'a'<= 25) {
                    small++;
                    continue;
                }
                if (c - 'A' >= 0 && c - 'A' <= 25) {
                    big++;
                    continue;
                }
                if (c - '0' >= 0 && c - '0' <= 9) {
                    num++;
                    continue;
                }
                if (c == ' ') {
                    space++;
                    continue;
                }
            }
            System.out.println(small + " " + big + " " + num + " " + space);
            line = br.readLine();
        }

    }

}
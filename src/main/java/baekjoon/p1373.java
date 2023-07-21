package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p1373 {
    /**
     * 문제: 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
     * 입력: 첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.
     * 출력: 첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("111100"));
        String num = br.readLine();
        int length = num.length(); // 주어지는 수의 길이는 1,000,000을 넘지 않으므로 int로 처리 불가하다.

        double inTen = 0;
        double systemTwo = 1;
        for (int i=length-1; i>=0; i--) {
            char c = num.charAt(i);
            if (c == '1') {
                inTen += systemTwo;
            }
            systemTwo *= 2;
        }

        if (inTen == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();
        while (inTen != 0) {
            result.append(inTen % 8);
            inTen /= 8;
        }

        System.out.println(result.reverse());
    }
}
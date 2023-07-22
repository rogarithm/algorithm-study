package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p1212 {
    /*
    문제 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
    입력 첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.
    출력 첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
     */
    // 1 -> 1 / 2 -> 10 / 7 -> 111 / 8 -> 1000
    // 21 -> 010001 -> 10001
    // 11 -> 001001 -> 1001
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("10"));
        String num = br.readLine();
        if (num.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();
        int first = num.charAt(0) - '0';
        while (first != 0) {
            result.append(first % 2);
            first /= 2;
        }
        result.reverse();

        for (int j =1; j<num.length(); j++) {
            StringBuilder elem = new StringBuilder();
            int current = num.charAt(j) - '0';
            while (current != 0) {
                elem.append(current % 2);
                current /= 2;
            }
            if (elem.length() == 0) elem.append("000");
            if (elem.length() == 1) elem.append("00");
            if (elem.length() == 2) elem.append("0");
            result.append(elem.reverse());
        }

        System.out.println(result);
    }

}
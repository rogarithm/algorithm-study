package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p11005 {

    /**
     * 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오. 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는
     * 다음과 같이 알파벳 대문자를 사용한다. A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     * <p>
     * 입력: 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다. 출력: 첫째 줄에 10진법 수 N을 B진법으로 출력한다.
     * <p>
     * 예제: 60466175 36 -> ZZZZZ
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("60466175 18"));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int system = Integer.parseInt(input[1]);
        StringBuilder result = new StringBuilder();

        int mod = num / system;
        int remainder = num % system;

        if (mod == 0) {
            if (remainder < 10) {
                System.out.println(remainder);
            } else {
                System.out.println((char) (remainder + 55));
            }
            return;
        }

        while (mod >= 0) {
            if (remainder <= 10) {
                result.append(remainder);
            } else {
                result.append((char) (remainder + 55));
            }

            if (mod == 0) {
                break;
            }

            remainder = mod % system;
            mod = mod / system;
        }

        System.out.println(result.reverse());
    }
}
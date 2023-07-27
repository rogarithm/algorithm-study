package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p2745 {

    /**
     * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오. 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는
     * 다음과 같이 알파벳 대문자를 사용한다. A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     * <p>
     * input 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
     * <p>
     * output 첫째 줄에 B진법 수 N을 10진법으로 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("100 2\n"));
        String[] input = br.readLine().split(" ");
        String num = input[0];
        int length = input[0].length();
        int system = 1; //오른쪽 맨 끝에서는 진법 관계 없이 1을 곱해야 한다
        int multiply = Integer.parseInt(input[1]);

        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c >= 49 && c <= 57) {
                result += ((c - 48) * system);
            } else if (c >= 65 && c <= 90) {
                result += ((c - 55) * system);
            }
            system *= multiply; //왼쪽으로 한 칸씩 이동할 때마다 진법 수만큼 곱해야 한다
        }

        System.out.println(result);
    }

}
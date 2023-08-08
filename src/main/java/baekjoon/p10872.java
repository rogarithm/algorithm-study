package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10872 {
    /*
    문제  0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
    입력  첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
    출력  첫째 줄에 N!을 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num == 0) {
            System.out.println(1);
            return;
        }
        int result = 1;
        while (num > 1) {
            result *= num;
            num--;
        }
        System.out.println(result);
        return;
    }

}
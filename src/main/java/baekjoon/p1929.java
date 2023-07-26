package baekjoon;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1929 {
    /*
    문제 M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
    입력 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
    출력 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     */
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new StringReader("3 16"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int from = parseInt(nums[0]);
        int to = parseInt(nums[1]);

        for (int i = from; i <= to; i++) {
            if (i == 1) continue;

            boolean isPrime=true;
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }

}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1850 {

    /**
     * 모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
     * 예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.
     * 입력: 첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 263보다 작은 자연수이다.
     * 출력: 첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        long num1 = Long.parseLong(nums[0]);
        long num2 = Long.parseLong(nums[1]);
        long ones = gcd(num1, num2);
        StringBuilder result = new StringBuilder();
        for (long i=0; i<ones; i++) {
            result.append('1');
        }
        System.out.println(result.toString());
        System.out.println();
    }

    static long gcd(long m, long n) {
        if (m % n == 0) return n;
        return gcd(n, m % n);
    }
}
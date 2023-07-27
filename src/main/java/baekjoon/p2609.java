package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2609 {

    /**
     * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오. 입력: 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의
     * 자연수이며 사이에 한 칸의 공백이 주어진다. 출력: 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ints = br.readLine().split(" ");
        int int1 = Integer.parseInt(ints[0]);
        int int2 = Integer.parseInt(ints[1]);

        System.out.println(gcd(int1, int2));
        System.out.println(lcm(int1, int2));
    }

    static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }

    static int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }

}
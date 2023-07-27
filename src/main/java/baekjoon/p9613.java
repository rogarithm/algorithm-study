package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            List<Integer> elems = new ArrayList<>();
            String[] testCase = br.readLine().split(" ");
            int count = Integer.parseInt(testCase[0]);
            for (int j = 0; j < count; j++) {
                elems.add(Integer.parseInt(testCase[j + 1]));
            }

            Long gcdSum = 0L;
            for (int k = 0; k < count; k++) {
                Integer left = elems.get(k);
                for (int l = k + 1; l < count; l++) {
                    Integer right = elems.get(l);
                    gcdSum += gcd(left, right);
                }
            }
            System.out.println(gcdSum);
        }
    }

    static long gcd(int m, int n) {
        int tmp = m;
        m = Math.max(tmp, n);
        n = Math.min(tmp, n);

        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }
}
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class p1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("3\n"
                + "1 45000\n"
                + "6 10\n"
                + "13 17"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i=0; i<count; i++) {
            String[] ints = br.readLine().split(" ");
            int int1 = Integer.parseInt(ints[0]);
            int int2 = Integer.parseInt(ints[1]);
            result.append(lcm(int1, int2)).append('\n');
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    static long gcd(int m, int n) {
        if (n == 0) return m;
        if (m % n == 0) return n;
        return gcd(n, m % n);
    }

    static long lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }
}
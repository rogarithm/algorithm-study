package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p6588 {

    public static void main(String[] args) throws IOException {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("8\n"
            + "20\n"
            + "42\n"
            + "0"));
        while (true) {
            int max = Integer.MIN_VALUE;
            int a = 0;
            int b = 0;
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            for (int i = 3; i < num; i = i + 2) {
                boolean isPrime = true;
                for (int j = 2; j < Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (!isPrime) {
                    continue;
                }

                isPrime = true;
                for (int j = 2; j < Math.sqrt(num - i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (!isPrime) {
                    continue;
                }

                if (num - i - i > max) {
                    a = i;
                    b = num - i;
                    max = num - 2 * i;
                }
            }

            if (a == 0 && b == 0) {
                System.out.println("Goldbach's conjecture is wrong.");
            } else {
                System.out.println(num + " = " + a + " + " + b);
            }
        }
    }

}
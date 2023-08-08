package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p1676 {

    /*
    문제  N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
    입력  첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
    출력  첫째 줄에 구한 0의 개수를 출력한다. 6 5 4 3 2 -> 6 20 6 -> 720
     */
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new StringReader("6"));
        //int num = Integer.parseInt(br.readLine());
        for (int n = 0; n < 500; n++) {
            int num = n;
            System.out.println("num is: " + num);
            if (num == 0) {
                System.out.println(0); //0! = 1이므로 0이 아닌 숫자가 나올 때까지의 0의 갯수는 0개다
                //return;
            }
            long factorial = 1; //long type으로도 500!까지의 수를 감당할 수 없다.
            //String 타입으로 쓰려고 해도, num이 1이 될 때까지 곱해야 해서 별반 다를 것이 없어 보인다.
            while (num > 1) {
                factorial *= num;
                num--;
            }
            System.out.println("\tfactorial: " + factorial);
            StringBuilder sb = new StringBuilder();
            sb.append(factorial).reverse();
            System.out.println("\treversed: " + sb.toString());

            int length = sb.length();
            for (int i=0; i< length; i++) {
                if (sb.charAt(i) == '0') continue;
                if (sb.charAt(i) != '0') {
                    System.out.println("\t" + i);
                    break;
                }
            }
        }
    }

    public void main2() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("6"));
        int num = Integer.parseInt(br.readLine());
        System.out.println("num is: " + num);
        if (num == 0) {
            System.out.println(0); //0! = 1이므로 0이 아닌 숫자가 나올 때까지의 0의 갯수는 0개다
            return;
        }
        long factorial = 1; //long type으로도 500!까지의 수를 감당할 수 없다.
        //String 타입으로 쓰려고 해도, num이 1이 될 때까지 곱해야 해서 별반 다를 것이 없어 보인다.
        while (num > 1) {
            factorial *= num;
            num--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(factorial).reverse();

        int length = sb.length();
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) == '0') {
                continue;
            }
            if (sb.charAt(i) != '0') {
                System.out.println(i);
                return;
            }
        }

    }
}
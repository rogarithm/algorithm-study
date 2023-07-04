package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class p11655 {
    
    private static char[] bigs = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'
    };
    private static char[] smalls = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'
    };

    public static void main(String[] args) throws IOException {
        //ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("Baek joon"));
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            //2글자 미는 경우를 생각해보자
            if (c - 'a' >= 0 && c - 'a' <= 12) {
                System.out.print(smalls[c - 'a' + 13]);
                continue;
            }
            if (c - 'a' >= 12 && c - 'a' <= 25) {
                System.out.print(smalls[c - 'a' + 13 - 26]);
                continue;
            }
            if (c - 'A' >= 0 && c - 'A' <= 12) {
                System.out.print(bigs[c - 'A' + 13]);
                continue;
            }
            if (c - 'A' >= 12 && c - 'A' <= 25) {
                System.out.print(bigs[c - 'A' + 13 - 26]);
                continue;
            }
            if (c == ' ') {
                System.out.print(' ');
                continue;
            }
            else System.out.print(c);
        }
    }

}
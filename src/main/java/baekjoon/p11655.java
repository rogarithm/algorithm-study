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
            //13글자만큼 밀어도 smalls의 인덱스를 벗어나지 않을 경우
            if (c - 'a' >= 0 && c - 'a' <= 12) {
                //그냥 밀면 된다
                System.out.print(smalls[c - 'a' + 13]);
                continue;
            }
            //13만큼 밀었을 때 small의 끝을 넘어가서 indexOutOfRange 예외가 발생하는 경우
            if (c - 'a' >= 12 && c - 'a' <= 25) {
                //벗어나는 만큼 첫 인덱스부터 밀어주면 된다
                System.out.print(smalls[c - 'a' + 13 - 26]);
                continue;
            }
            //대문자도 소문자와 마찬가지
            if (c - 'A' >= 0 && c - 'A' <= 12) {
                System.out.print(bigs[c - 'A' + 13]);
                continue;
            }
            if (c - 'A' >= 12 && c - 'A' <= 25) {
                System.out.print(bigs[c - 'A' + 13 - 26]);
                continue;
            }

            //빈 칸일 경우 그대로 출력한다
            if (c == ' ') {
                System.out.print(' ');
                continue;
            }
            //이외의 경우도 그대로 출력한다
            else System.out.print(c);
        }
    }

}
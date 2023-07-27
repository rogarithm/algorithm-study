package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class p10430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(""));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split(" ");
        Integer A = Integer.parseInt(numbers[0]);
        Integer B = Integer.parseInt(numbers[1]);
        Integer C = Integer.parseInt(numbers[2]);
        //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        StringBuilder result = new StringBuilder();
        result.append((A + B) % C).append('\n')
            .append(((A % C) + (B % C)) % C).append('\n')
            .append((A * B) % C).append('\n')
            .append(((A % C) * (B % C)) % C);
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
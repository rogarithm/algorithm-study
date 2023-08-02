package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p11653 {

    /*
    문제 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
    입력 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
    출력 N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.

    2 이상의 수로 나눴을 때 나머지가 0이면 소인수다
    어떤 수로 나누고 나머지가 0이면, 나눈 수를 목록에 추가하고, 나눈 후 몫을 가지고 계산을 계속해 나간다
    8 % 2 = 0 -> 몫 4 나머지 0 결과 2
    4 % 2 = 0 -> 몫 2 나머지 0 결과 2 2
    2 % 2 = 0 -> 몫 1 나머지 0 결과 2 2
    몫 또는 주어진 수가 1이면 멈춘다
    나누는 수가 소수가 아니면 그 수가 아니라 그 수를 이루는 소수 목록을 소인수에 포함해야 한다

    소인수는 오름차순이므로, 결과를 순서대로 저장했다가 나중에 정렬하거나, 처음에 결과를 저장할 때 정렬해야할 것 같다
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader("9991"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        List<Integer> divs = new ArrayList<>(1000);
        int bound = num / 2;
        while (true) {
            if (num == 1) break;
            for (int div = 2; div <= bound; div++) {
                if (num % div == 0) {
                    divs.add(div);
                    num = num / div;
                    break;
                }
            }
        }

        Collections.sort(divs);
        StringBuilder result = new StringBuilder();
        for (Integer r : divs) {
            result.append(r).append('\n');
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
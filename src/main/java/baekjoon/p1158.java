package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class p1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("7 3"));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        StringBuilder result = new StringBuilder().append('<');
        while (deque.size() > 1) { // size() == 1인 조건이 없으면 아래 ", " 추가하는 문장에 조건문 필요없다
            for (int i = 0; i < k - 1; i++) {
                deque.offer(deque.poll()); // poll()로 현재 인덱스의 요소를 빼서 offer()로 deque의 맨 뒤에 집어넣는다
            }
            result.append(deque.poll()).append(", "); // k번째 요소는 삭제해야 하니까 offer()하지 않는다
        }
        result.append(deque.poll()).append('>'); // size()가 1일 때는 남은 요소가 하나니까 이걸 그냥 결과에 넣으면 된다

        System.out.println(result);
    }
}
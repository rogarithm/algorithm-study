package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class p1158 {
    //요세푸스 문제
    //1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
    //이제 순서대로 K번째 사람을 제거한다.
    //한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
    //이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
    //원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
    //예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
    //12(3)4567 -> 12|45(6)7 -> 1(2)|45|7 -> 1|45(7) -> 14(5) -> (1)4 -> (4)

    //N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

    //첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

    //제거한 사람의 인덱스 바로 다음 인덱스부터 K만큼 세서 값을 빼자
    //다시 처음 인덱스로 돌아올 수 있는 자료구조가 있나? deque?
    //iterator로 순회하면서 마지막 인덱스에 도착하면 다음 인덱스가 처음 인덱스가 되도록 설정할 수 있으면 될 것 같다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("7 3"));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=n; i++) {
            deque.add(i);
        }

        Iterator<Integer> iterator = deque.iterator();
        StringBuilder result = new StringBuilder().append('<');
        while (deque.size() >= 1) {
            Integer removed = Integer.MIN_VALUE;
            for (int i=0; i<k; i++) {
                if (!iterator.hasNext()) {
                    iterator = deque.iterator();
                }
                removed = iterator.next();
            }
            deque.remove(removed);
            if (deque.size() > 1)
                result.append(removed).append(", ");
        }
        result.append('>');

        System.out.println(result);
    }
}
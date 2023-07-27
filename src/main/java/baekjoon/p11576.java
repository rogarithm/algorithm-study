package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p11576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] systems = br.readLine().split(" ");
        int from = Integer.parseInt(systems[0]);
        int to = Integer.parseInt(systems[1]);
        int numCount = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int fromSum = 0;
        for (int i = 0; i < numCount; i++) {
            fromSum += Integer.parseInt(nums[i]) * Math.pow(from, numCount - i - 1);
        }

        //StringBuilder로 하면 한 요소가 두 개 이상일 때 결과로 출력할 수 없다. 예를 들어,
        //12 13 이 결과라고 하면, 1 2 1 3이 결과로 나온다. 따라서 각 요소의 길이를 결과 출력 시에도 유지할 수 있는 방법이 필요하다.
        //스택으로 구현해보자.
        Stack<Integer> stack = new Stack<>();
        while (fromSum != 0) {
            stack.push(fromSum % to);
            fromSum /= to;
        }

        //size()로 pop() 횟수를 계산했을 때 제대로 나오지 않는 경우가 있었다. 왜 그럴까?
        //pop()하면 size()가 바뀌기 때문이었다
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            System.out.print(" ");
        }
        System.out.println();
    }
}
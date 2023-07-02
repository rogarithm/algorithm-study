package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class p10845 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new StringReader("15\n"
        //        + "push 1\n" + "push 2\n" + "front\n" + "back\n" + "size\n"
        //        + "empty\n" + "pop\n" + "pop\n" + "pop\n" + "size\n"
        //        + "empty\n" + "pop\n" + "push 3\n" + "empty\n" + "front"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();

        for (int i = 0; i < count; i++) {
            String commandAndArg = br.readLine();
            String[] split = commandAndArg.split(" ");
            String command = split[0];
            if (command.equals("push")) {
                queue.push(Integer.parseInt(split[1]));
            }
            if (command.equals("pop")) {
                System.out.println(queue.pop());
            }
            if (command.equals("size")) {
                System.out.println(queue.size());
            }
            if (command.equals("empty")) {
                System.out.println(queue.empty());
            }
            if (command.equals("front")) {
                System.out.println(queue.front());
            }
            if (command.equals("back")) {
                System.out.println(queue.back());
            }
        }
    }

    private static class MyQueue {

        List<Integer> list;

        public MyQueue() {
            list = new ArrayList<>();
        }

        //push X: 정수 X를 큐에 넣는 연산이다.
        void push(int i) {
            list.add(i);
        }

        //pop   : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            Integer removed = list.remove(0);
            return removed;
        }

        //size  : 큐에 들어있는 정수의 개수를 출력한다.
        int size() {
            return list.size();
        }

        //empty : 큐가 비어있으면 1, 아니면 0을 출력한다.
        int empty() {
            if (size() == 0) {
                return 1;
            }
            return 0;
        }

        //front : 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int front() {
            if (size() == 0) {
                return -1;
            }
            return list.get(0);
        }

        //back  : 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int back() {
            if (size() == 0) {
                return -1;
            }
            return list.get(size());
        }

    }
}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();
        for (int i=0; i<count; i++) {
            String[] commandAndArg = br.readLine().split(" ");
            String command = commandAndArg[0];
            if (command.equals("push_front"))
                deque.push_front(Integer.parseInt(commandAndArg[1]));
            if (command.equals("push_back"))
                deque.push_back(Integer.parseInt(commandAndArg[1]));
            if (command.equals("pop_front"))
                System.out.println(deque.pop_front());
            if (command.equals("pop_back"))
                System.out.println(deque.pop_back());
            if (command.equals("size"))
                System.out.println(deque.size());
            if (command.equals("empty"))
                System.out.println(deque.empty());
            if (command.equals("front"))
                System.out.println(deque.front());
            if (command.equals("back"))
                System.out.println(deque.back());
        }
    }

    private static class MyDeque {
        private List<Integer> list;

        public MyDeque() { list = new ArrayList<>(); }

        //push_front X : 정수 X를 덱의 앞에 넣는다.
        void push_front(int x) { list.add(0, x); }
        //push_back X  : 정수 X를 덱의 뒤에 넣는다.
        void push_back(int x) { list.add(x); }
        //pop_front    : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int pop_front() {
            if (size() == 0) return -1;
            return list.remove(0);
        }
        //pop_back     : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int pop_back() {
            if (size() == 0) return -1;
            return list.remove(size() - 1);
        }
        //size         : 덱에 들어있는 정수의 개수를 출력한다.
        int size() { return list.size(); }
        //empty        : 덱이 비어있으면 1을, 아니면 0을 출력한다.
        int empty() { return size() == 0 ? 1 : 0; }
        //front        : 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int front() { return size() == 0 ? -1 : list.get(0); }
        //back         : 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        int back() { return size() == 0 ? -1 : list.get(size() - 1); }
    }
}
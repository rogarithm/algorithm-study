package baekjoon;

import java.util.*;
import java.io.*;

public class p10799 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("(((()(()()))(())()))(()())"));

        String parens = br.readLine();
        Deque<String> deque = new ArrayDeque<>();
        int result = 0;
        for (int i=0; i<parens.length(); i++) {
            char paren = parens.charAt(i);
            //deque에는 레이저('()')가 아닌 괄호만 넣어야 한다
            //'('를 만나면 일단 deque에 넣는다
            if (paren == '(') {
                deque.push("(");
            }
            else if (paren == ')') {
                // 레이저를 구성하지 않는 ')' 문자일 때는 레이저로 자른 나머지 반쪽 하나하나를 의미한다.
                // 따라서 한 번에 1을 더한다
                if (i > 0 && parens.charAt(i-1) == ')') {
                    deque.pop();
                    result += 1;
                    continue;
                }

                // '(' 바로 다음 문자가 ')'이면 레이저다. deque에 저장했던 '('는 레이저의 일부이므로 뺀다
                if (i > 0 && parens.charAt(i-1) == '(') {
                    deque.pop();
                    // 여러 막대기가 겹쳐있을 때는 () 앞에 있는 (의 갯수로 겹쳐진 막대기의 갯수를 알 수 있다
                    result += deque.size();
                }
            }
            // 아니라면 그대로 둔다
        }

        System.out.println(result);
    }
}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * L 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
 * D 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
 * B 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
 * P$ $라는 문자를 커서 왼쪽에 추가함
 */
public class p1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("dmih\n"
                + "11\n"
                + "B\n"
                + "B\n"
                + "P x\n"
                + "L\n"
                + "B\n"
                + "B\n"
                + "B\n"
                + "P y\n"
                + "D\n"
                + "D\n"
                + "P z"
                ));
        String word = br.readLine();
        Integer count = Integer.parseInt(br.readLine());

        String result = word;
        int cursor = result.length();
        int length = result.length();
        int cnt = 0;
        for (int i=0; i<count; i++) {
            cnt++;
            String command = br.readLine();
            if (command.equals("L") && cursor > 0)
                cursor--;
            if (command.equals("D") && cursor < length)
                cursor++;
            if (command.equals("B") && cursor != 0) {
                String left = result.substring(0, cursor - 1);
                String right = "";
                if (cursor < length) {
                    right = result.substring(cursor);
                }

                if (!right.equals("")) {
                    result = left + right;
                } else {
                    result = left;
                }
                cursor--;
                length--;
            }
            if (command.substring(0,1).equals("P")) {
                String c = command.split(" ")[1];
                String left = result.substring(0, cursor);
                String right = "";
                if (cursor < length) {
                    right = result.substring(cursor);
                }

                if (!right.equals("")) {
                    result = left + c + right;
                } else {
                    result = left + c;
                }

                cursor++;
                length++;
            }

            System.out.println(cnt + ": " + result + ", cursor: " + cursor + ", length: " + length);
        }

        System.out.println(result);
    }
}
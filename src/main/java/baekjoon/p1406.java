package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class p1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        Integer count = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();
        for (Character c : word.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        for (int i=0; i<count; i++) {
            String command = br.readLine();
            if (command.equals("L") && iter.hasPrevious())
                iter.previous();
            if (command.equals("D") && iter.hasNext())
                iter.next();
            if (command.equals("B") && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            }
            if (command.substring(0,1).equals("P")) {
                iter.add(command.charAt(2));
            }
        }

        for (Character c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}